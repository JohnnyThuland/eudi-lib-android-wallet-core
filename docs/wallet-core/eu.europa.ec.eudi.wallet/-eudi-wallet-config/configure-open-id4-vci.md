//[wallet-core](../../../index.md)/[eu.europa.ec.eudi.wallet](../index.md)/[EudiWalletConfig](index.md)/[configureOpenId4Vci](configure-open-id4-vci.md)

# configureOpenId4Vci

[androidJvm]\
fun [configureOpenId4Vci](configure-open-id4-vci.md)(openId4VciConfig: [OpenId4VciManager.Config](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/index.md)): &lt;Error class: unknown class&gt;

Configure OpenID for Verifiable Credential Issuance (OpenID4VCI). This configuration is used by [EudiWallet.createOpenId4VciManager](../-eudi-wallet/create-open-id4-vci-manager.md) when no specific config is provided.

#### Return

the [EudiWalletConfig](index.md) instance

#### Parameters

androidJvm

| | |
|---|---|
| openId4VciConfig | the OpenID4VCI configuration |

#### See also

| |
|---|
| [OpenId4VciManager.Config](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/index.md) |
| [OpenId4VciManager.Config.Builder](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/-builder/index.md) |

[androidJvm]\
fun [configureOpenId4Vci](configure-open-id4-vci.md)(openId4VciConfig: [OpenId4VciManager.Config.Builder](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/-builder/index.md).() -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin-stdlib/kotlin/-unit/index.html)): &lt;Error class: unknown class&gt;

Configure OpenID for Verifiable Credential Issuance (OpenID4VCI) using a builder pattern. This configuration is used by [EudiWallet.createOpenId4VciManager](../-eudi-wallet/create-open-id4-vci-manager.md) when no specific config is provided.

#### Return

the [EudiWalletConfig](index.md) instance

#### Parameters

androidJvm

| | |
|---|---|
| openId4VciConfig | the OpenID4VCI configuration lambda with [OpenId4VciManager.Config.Builder](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/-builder/index.md) as receiver |

#### See also

| |
|---|
| [OpenId4VciManager.Config](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/index.md) |
| [OpenId4VciManager.Config.Builder](../../eu.europa.ec.eudi.wallet.issue.openid4vci/-open-id4-vci-manager/-config/-builder/index.md) |
