/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.search.backend.lucene.lowlevel.index.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import org.hibernate.search.backend.lucene.logging.impl.LuceneMiscLog;
import org.hibernate.search.backend.lucene.lowlevel.common.impl.AnalyzerConstants;
import org.hibernate.search.backend.lucene.lowlevel.directory.spi.DirectoryHolder;
import org.hibernate.search.backend.lucene.lowlevel.reader.impl.IndexReaderProvider;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterDelegator;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterDelegatorImpl;
import org.hibernate.search.backend.lucene.lowlevel.writer.impl.IndexWriterProvider;
import org.hibernate.search.util.common.impl.Closer;
import org.hibernate.search.util.common.reporting.EventContext;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SleepingLockWrapper;

/**
 * @author Sanne Grinovero (C) 2011 Red Hat Inc.
 */
public class IndexAccessorImpl implements AutoCloseable, IndexAccessor {

    private final EventContext eventContext;

    private final DirectoryHolder directoryHolder;

    private final IndexWriterProvider indexWriterProvider;

    private final IndexReaderProvider indexReaderProvider;

    public IndexAccessorImpl(EventContext eventContext, DirectoryHolder directoryHolder, IndexWriterProvider indexWriterProvider, IndexReaderProvider indexReaderProvider) {
        this.eventContext = eventContext;
        this.directoryHolder = directoryHolder;
        this.indexWriterProvider = indexWriterProvider;
        this.indexReaderProvider = indexReaderProvider;
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void createIndexIfMissing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void validateIndexExists() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void dropIndexIfExisting() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void commitOrDelay() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void mergeSegments() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IndexWriterDelegator getIndexWriterDelegator() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DirectoryReader getIndexReader() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cleanUpAfterFailure(Throwable throwable, Object failingOperation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long computeSizeInBytes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Directory getDirectoryForTests() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexWriter getWriterForTests() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IndexReader getCurrentReaderForTests() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void initializeDirectory(Directory directory) throws IOException {
        try {
            IndexWriterConfig iwriterConfig = new IndexWriterConfig(AnalyzerConstants.KEYWORD_ANALYZER).setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            //Needs to have a timeout higher than zero to prevent race conditions over (network) RPCs
            //for distributed indexes (Infinispan but probably also NFS and similar)
            SleepingLockWrapper delayedDirectory = new SleepingLockWrapper(directory, 2000, 20);
            IndexWriter iw = new IndexWriter(delayedDirectory, iwriterConfig);
            iw.close();
        } catch (LockObtainFailedException lofe) {
            LuceneMiscLog.INSTANCE.lockingFailureDuringInitialization(directory.toString(), eventContext, lofe);
        }
    }
}
