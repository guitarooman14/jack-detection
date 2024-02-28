# jack-detection

should detect when jack is plugged or unplugged

## Install

```bash
npm install jack-detection
npx cap sync
```

## API

<docgen-index>

* [`getStatus()`](#getstatus)
* [`addListener('jackStatusChange', ...)`](#addlistenerjackstatuschange-)
* [`removeAllListeners()`](#removealllisteners)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### getStatus()

```typescript
getStatus() => Promise<boolean>
```

Query the current status of the jack.

**Returns:** <code>Promise&lt;boolean&gt;</code>

**Since:** 1.0.0

--------------------


### addListener('jackStatusChange', ...)

```typescript
addListener(eventName: 'jackStatusChange', listenerFunc: JackStatusChangeListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listen for changes of the jack status.

| Param              | Type                                                                          |
| ------------------ | ----------------------------------------------------------------------------- |
| **`eventName`**    | <code>'jackStatusChange'</code>                                               |
| **`listenerFunc`** | <code><a href="#jackstatuschangelistener">JackStatusChangeListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

**Since:** 1.0.0

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

Remove all listeners for this plugin.

**Since:** 1.0.0

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


#### JackStatus

Represents the state and type of the network connection.

| Prop            | Type                 | Description                         | Since |
| --------------- | -------------------- | ----------------------------------- | ----- |
| **`connected`** | <code>boolean</code> | Whether the jack is plugged or not. | 1.0.0 |


### Type Aliases


#### JackStatusChangeListener

Callback to receive the status change notifications.

<code>(status: <a href="#jackstatus">JackStatus</a>): void</code>

</docgen-api>
