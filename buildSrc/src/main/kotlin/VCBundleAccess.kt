import org.gradle.api.artifacts.VersionCatalog

class VCBundleAccess internal constructor(versionCatalog: VersionCatalog) :
    VersionCatalog by versionCatalog {
        operator fun get(name: String) = getByName(name, VersionCatalog::findBundle)
    }
