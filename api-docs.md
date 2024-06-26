
<docgen-index>

* [`isBatterySaverPermissionAvailable(...)`](#isbatterysaverpermissionavailable)
* [`requestAutoStart(...)`](#requestautostart)
* [`requestKeepAppActive(...)`](#requestkeepappactive)
* [`requestRunInBackground(...)`](#requestruninbackground)
* [`openAppInfo(...)`](#openappinfo)

</docgen-index>

<docgen-api>

### isBatterySaverPermissionAvailable(...)

```typescript
isBatterySaverPermissionAvailable() => Promise<{ ignoring: boolean; }>
```
--------------------

### requestAutoStart(...)

```typescript
requestAutoStart() => Promise<{ requested: boolean; }>
```

This method requests to add the app to the auto-start whitelist.

--------------------

### requestKeepAppActive(...)

```typescript
requestKeepAppActive() => Promise<{ requested: boolean; }>
```

This method requests to keep the app active and prevent it from being paused.

--------------------

### requestRunInBackground(...)

```typescript
requestRunInBackground() => Promise<{ requested: boolean; }>
```

This method requests the app to run in the background by combining battery saver and auto-start permissions.





--------------------

### openappinfo(...)

```typescript
openAppInfo() => Promise<{ opening: boolean; }>
```

This method app info settings using the following method

</docgen-api>
