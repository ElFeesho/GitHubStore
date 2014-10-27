package uk.co.amlcurran.githubstore;

public interface Downloader {

    void downloadApk(Release release, int apkIndex, Downloader.Listener listener);

    public interface Listener {
        void downloadedApk(Release release, int apkIndex);
    }
}
