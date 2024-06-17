// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "SquareetlabsCapacitorDontKillMyApp",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "SquareetlabsCapacitorDontKillMyApp",
            targets: ["DontKillMyAppPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "DontKillMyAppPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/DontKillMyAppPlugin"),
        .testTarget(
            name: "DontKillMyAppPluginTests",
            dependencies: ["DontKillMyAppPlugin"],
            path: "ios/Tests/DontKillMyAppPluginTests")
    ]
)
