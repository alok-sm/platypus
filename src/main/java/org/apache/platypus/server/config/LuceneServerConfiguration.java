/*
 *
 *  * Copyright 2019 Yelp Inc.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *  * either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

package org.apache.platypus.server.config;

import com.google.inject.Inject;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LuceneServerConfiguration {
    public final static Path DEFAULT_USER_DIR = Paths.get(System.getProperty("user.home"), "lucene", "server");
    public final static Path DEFAULT_ARCHIVER_DIR = Paths.get(DEFAULT_USER_DIR.toString(), "archiver");
    public final static Path DEFAULT_BOTO_CFG_PATH = Paths.get(DEFAULT_USER_DIR.toString(), "boto.cfg");
    public final static Path DEFAULT_STATE_DIR = Paths.get(DEFAULT_USER_DIR.toString(), "default_state");
    public final static Path DEFAULT_INDEX_DIR = Paths.get(DEFAULT_USER_DIR.toString(), "default_index");
    private static final String DEFAULT_BUCKET_NAME = "DEFAULT_ARCHIVE_BUCKET";
    private static final String DEFAULT_HOSTNAME = "localhost";
    private static final int DEFAULT_PORT = 50051;
    private static final int DEFAULT_REPLICATION_PORT = 50052;
    private static final String DEFAULT_NODE_NAME = "main";
    //buckets represent number of requests completed in "less than" seconds
    private static final double[] DEFAULT_METRICS_BUCKETS = new double[]{.005, .01, .025, .05, .075, .1, .25, .5, .75, 1, 2.5, 5, 7.5, 10};

    private int port = DEFAULT_PORT;
    private int replicationPort = DEFAULT_REPLICATION_PORT;
    private String nodeName = DEFAULT_NODE_NAME;
    private String hostName = DEFAULT_HOSTNAME;
    private String stateDir = DEFAULT_STATE_DIR.toString();
    private String indexDir = DEFAULT_INDEX_DIR.toString();
    private String archiveDirectory = DEFAULT_ARCHIVER_DIR.toString();
    private String botoCfgPath = DEFAULT_BOTO_CFG_PATH.toString();
    private String bucketName = DEFAULT_BUCKET_NAME;
    private double[] metricsBuckets = DEFAULT_METRICS_BUCKETS;

    @Inject
    public LuceneServerConfiguration() {
    }

    public int getPort() {
        return port;
    }

    public int getReplicationPort() {
        return replicationPort;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getStateDir() {
        return stateDir;
    }

    public String getIndexDir() {
        return indexDir;
    }

    public String getHostName() {
        return hostName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setReplicationPort(int replicationPort) {
        this.replicationPort = replicationPort;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setStateDir(String stateDir) {
        this.stateDir = stateDir;
    }

    public void setIndexDir(String indexDir) {
        this.indexDir = indexDir;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }


    public String getBotoCfgPath() {
        return botoCfgPath;
    }

    public void setBotoCfgPath(String botoCfgPath) {
        this.botoCfgPath = botoCfgPath;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getArchiveDirectory() {
        return archiveDirectory;
    }

    public void setArchiveDirectory(String archiveDirectory) {
        this.archiveDirectory = archiveDirectory;
    }

    public double[] getMetricsBuckets() {
        return metricsBuckets;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LuceneServerConfiguration{");
        sb.append("port=").append(port);
        sb.append(", replicationPort=").append(replicationPort);
        sb.append(", nodeName='").append(nodeName).append('\'');
        sb.append(", hostName='").append(hostName).append('\'');
        sb.append(", stateDir='").append(stateDir).append('\'');
        sb.append(", indexDir='").append(indexDir).append('\'');
        sb.append(", archiveDirectory='").append(archiveDirectory).append('\'');
        sb.append(", botoCfgPath='").append(botoCfgPath).append('\'');
        sb.append(", bucketName='").append(bucketName).append('\'');
        sb.append(", metricsBuckets=").append(Arrays.toString(metricsBuckets));
        sb.append('}');
        return sb.toString();
    }


    public static class Builder {
        private final double[] metricsBuckets;
        private String hostName;
        private int replicationPort;
        private int port;
        private String nodeName;
        private Path stateDir;
        private Path indexDir;
        private String archiveDirectory;
        private String botoCfgPath;
        private String bucketName;

        public Builder() {
            //set default values
            this.nodeName = DEFAULT_NODE_NAME;
            this.hostName = DEFAULT_HOSTNAME;
            this.stateDir = DEFAULT_STATE_DIR;
            this.indexDir = DEFAULT_INDEX_DIR;
            this.port = DEFAULT_PORT;
            this.replicationPort = DEFAULT_REPLICATION_PORT;
            this.archiveDirectory = DEFAULT_ARCHIVER_DIR.toString();
            this.botoCfgPath = DEFAULT_BOTO_CFG_PATH.toString();
            this.bucketName = DEFAULT_BUCKET_NAME;
            this.metricsBuckets = DEFAULT_METRICS_BUCKETS;
        }

        public Builder withStateDir(String tempStateDir) {
            this.stateDir = Paths.get(tempStateDir);
            return this;
        }

        public Builder withIndexDir(String tempIndexDir) {
            this.indexDir = Paths.get(tempIndexDir);
            return this;
        }

        public Builder withNodeName(String nodeName) {
            this.nodeName = nodeName;
            return this;
        }


        public Builder withPort(int port) {
            this.port = port;
            return this;
        }

        public Builder withReplicationPort(int replicationPort) {
            this.replicationPort = replicationPort;
            return this;
        }

        public Builder withHostName(String hostName) {
            this.hostName = hostName;
            return this;
        }

        public Builder withArchiveDirectory(String archiveDirectory) {
            this.archiveDirectory = archiveDirectory;
            return this;
        }

        public Builder withBotoCfgPath(String botoCfgPath) {
            this.botoCfgPath = botoCfgPath;
            return this;
        }

        public Builder withBucketName(String bucketName) {
            this.bucketName = bucketName;
            return this;
        }

        public LuceneServerConfiguration build() {
            LuceneServerConfiguration luceneServerConfiguration = new LuceneServerConfiguration();
            luceneServerConfiguration.nodeName = this.nodeName;
            luceneServerConfiguration.stateDir = this.stateDir.toString();
            luceneServerConfiguration.indexDir = this.indexDir.toString();
            luceneServerConfiguration.port = this.port;
            luceneServerConfiguration.hostName = this.hostName;
            luceneServerConfiguration.replicationPort = this.replicationPort;
            luceneServerConfiguration.archiveDirectory = this.archiveDirectory;
            luceneServerConfiguration.botoCfgPath = this.botoCfgPath;
            luceneServerConfiguration.bucketName = this.bucketName;
            luceneServerConfiguration.metricsBuckets = this.metricsBuckets;
            return luceneServerConfiguration;
        }

    }


}
