/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.elasticsearch.client.common.gson.entity.spi;

import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * A writer to a ContentEncoder, using an automatically growing, paged buffer
 * to store input when flow control pushes back.
 * <p>
 * To be used when your input source is not reactive (uses {@link Writer}),
 * but you have multiple elements to write and thus could take advantage of
 * reactive output to some extent.
 *
 * @author Sanne Grinovero
 */
class ProgressiveCharBufferWriter extends Writer {

    private final CharsetEncoder charsetEncoder;

    /**
     * Size of buffer pages.
     */
    private final int pageSize;

    /**
     * A higher-level buffer for chars, so that we don't have
     * to wrap every single incoming char[] into a CharBuffer.
     */
    private final CharBuffer charBuffer;

    /**
     * Filled buffer pages to be written, in write order.
     */
    private final Deque<ByteBuffer> needWritingPages = new ArrayDeque<>(5);

    /**
     * Current buffer page, potentially null,
     * which may have some content but isn't full yet.
     */
    private ByteBuffer currentPage;

    /**
     * Initially null: must be set before writing is started and each
     * time it's resumed as it might change between writes during
     * chunked encoding.
     */
    private ContentEncoder output;

    /**
     * Set this to true when we detect clogging, so we can stop trying.
     * Make sure to reset this when the HTTP Client hints so.
     * It's never dangerous to re-enable, just not efficient to try writing
     * unnecessarily.
     */
    private boolean flowControlPushingBack = false;

    private int contentLength = 0;

    public ProgressiveCharBufferWriter(Charset charset, int charBufferSize, int pageSize) {
        this.charsetEncoder = charset.newEncoder();
        this.pageSize = pageSize;
        this.charBuffer = CharBuffer.allocate(charBufferSize);
    }

    /**
     * Set the encoder to write to when buffers are full.
     */
    public void setOutput(ContentEncoder output) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Overrides super.write(int) to remove the synchronized() wrapper.
    // WARNING: when you update this method, make sure to update ALL write(...) methods.
    @Override
    public void write(int c) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Overrides super.write(String, int, int) to remove the synchronized() wrapper.
    // WARNING: when you update this method, make sure to update ALL write(...) methods.
    @Override
    public void write(String str, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // WARNING: when you update this method, make sure to update ALL write(...) methods.
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void flush() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send all full buffer pages to the {@link #setOutput(ContentEncoder) output}.
     * <p>
     * Flow control may push back, in which case this method or {@link #flushToOutput()}
     * should be called again later.
     *
     * @throws IOException when {@link org.apache.http.nio.ContentEncoder#write(ByteBuffer)} fails.
     */
    public void resumePendingWrites() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return {@code true} if the {@link #setOutput(ContentEncoder) output} pushed
     * back the last time a write was attempted, {@code false} otherwise.
     */
    public boolean isFlowControlPushingBack() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Send all buffer pages to the {@link #setOutput(ContentEncoder) output},
     * Even those that are not full yet
     * <p>
     * Flow control may push back, in which case this method should be called again later.
     *
     * @throws IOException when {@link org.apache.http.nio.ContentEncoder#write(ByteBuffer)} fails.
     */
    public void flushToOutput() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The length of the content stored in the byte buffers so far, in bytes.
     * This does include the content that has already been written to the {@link #setOutput(ContentEncoder) output},
     * but not the content of the char buffer (which can be flushed to byte buffers using {@link #flush()}).
     */
    public int contentLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void writeToByteBuffer(CharBuffer input) throws IOException {
        while (true) {
            if (currentPage == null) {
                currentPage = ByteBuffer.allocate(pageSize);
            }
            int initialPagePosition = currentPage.position();
            CoderResult coderResult = charsetEncoder.encode(input, currentPage, false);
            contentLength += (currentPage.position() - initialPagePosition);
            if (coderResult.equals(CoderResult.UNDERFLOW)) {
                return;
            } else if (coderResult.equals(CoderResult.OVERFLOW)) {
                // Avoid storing buffers if we can simply flush them
                attemptFlushPendingBuffers(true);
                if (currentPage != null) {
                    /*
					 * We couldn't flush the current page, but it's full,
					 * so let's move it out of the way.
					 */
                    currentPage.flip();
                    needWritingPages.add(currentPage);
                    currentPage = null;
                }
            } else {
                //Encoding exception
                coderResult.throwException();
                //Unreachable
                return;
            }
        }
    }

    /**
     * @return {@code true} if this buffer contains content to be written, {@code false} otherwise.
     */
    private boolean hasRemaining() {
        return !needWritingPages.isEmpty() || currentPage != null && currentPage.position() > 0;
    }

    private void attemptFlushPendingBuffers(boolean flushCurrentPage) throws IOException {
        if (output == null) {
            flowControlPushingBack = true;
        }
        if (flowControlPushingBack || !hasRemaining()) {
            // Nothing to do
            return;
        }
        Iterator<ByteBuffer> iterator = needWritingPages.iterator();
        while (iterator.hasNext() && !flowControlPushingBack) {
            ByteBuffer buffer = iterator.next();
            boolean written = write(buffer);
            if (written) {
                iterator.remove();
            } else {
                flowControlPushingBack = true;
            }
        }
        if (flushCurrentPage && !flowControlPushingBack && currentPage != null && currentPage.position() > 0) {
            // The encoder still accepts some input, and we are allowed to flush the current page. Let's do.
            currentPage.flip();
            boolean written = write(currentPage);
            if (!written) {
                flowControlPushingBack = true;
                needWritingPages.add(currentPage);
            }
            currentPage = null;
        }
    }

    private boolean write(ByteBuffer buffer) throws IOException {
        final int toWrite = buffer.remaining();
        // We should never do 0-length writes, see HSEARCH-2854
        if (toWrite == 0) {
            return true;
        }
        final int actuallyWritten = output.write(buffer);
        return toWrite == actuallyWritten;
    }
}
