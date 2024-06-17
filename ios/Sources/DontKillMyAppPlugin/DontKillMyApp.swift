import Foundation

@objc public class DontKillMyApp: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
