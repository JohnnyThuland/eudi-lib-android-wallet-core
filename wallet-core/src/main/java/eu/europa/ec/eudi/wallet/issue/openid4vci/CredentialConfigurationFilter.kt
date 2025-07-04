/*
 * Copyright (c) 2024 European Commission
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.europa.ec.eudi.wallet.issue.openid4vci

import eu.europa.ec.eudi.openid4vci.CredentialConfiguration
import eu.europa.ec.eudi.openid4vci.MsoMdocCredential
import eu.europa.ec.eudi.openid4vci.SdJwtVcCredential
import eu.europa.ec.eudi.wallet.issue.openid4vci.CredentialConfigurationFilter.Companion.MsoMdocFormatFilter
import kotlin.reflect.KClass

/**
 * Filter for [CredentialConfiguration] instances.
 */
internal fun interface CredentialConfigurationFilter {
    operator fun invoke(conf: CredentialConfiguration): Boolean = filter(conf)
    fun filter(conf: CredentialConfiguration): Boolean

    /**
     * Companion object for [CredentialConfigurationFilter] instances.
     * @property MsoMdocFormatFilter filter for [CredentialConfiguration] instances for mso_mdoc format
     */
    companion object {

        /**
         * Filter for [CredentialConfiguration] instances based on the credential format.
         * @param format credential format
         * @return [CredentialConfigurationFilter] instance
         */
        @JvmSynthetic
        internal fun FormatFilter(format: KClass<out CredentialConfiguration>) =
            CredentialConfigurationFilter { conf ->
                format.isInstance(conf)
            }

        /**
         * Filter for [CredentialConfiguration] instances for mso_mdoc format
         */
        @JvmSynthetic
        internal val MsoMdocFormatFilter: CredentialConfigurationFilter =
            FormatFilter(MsoMdocCredential::class)

        /**
         * Filter for [CredentialConfiguration] instances based on the document type.
         * @param docType document type
         * @return [CredentialConfigurationFilter] instance
         */
        @JvmSynthetic
        internal fun DocTypeFilter(docType: String): CredentialConfigurationFilter =
            CredentialConfigurationFilter { conf ->
                when (conf) {
                    is MsoMdocCredential -> conf.docType == docType
                    else -> false
                }
            }

        /**
         * Filter for [CredentialConfiguration] instances based on the vct.
         * @param vct vct
         * @return [CredentialConfigurationFilter] instance
         */
        @JvmSynthetic
        internal fun VctFilter(vct: String): CredentialConfigurationFilter =
            CredentialConfigurationFilter { conf ->
                when (conf) {
                    is SdJwtVcCredential -> conf.type == vct
                    else -> false
                }
            }

        /**
         * Compose multiple [CredentialConfigurationFilter] instances.
         * @param filters [CredentialConfigurationFilter] instances
         * @return [CredentialConfigurationFilter] instance
         */
        @JvmSynthetic
        internal fun Compose(vararg filters: CredentialConfigurationFilter): CredentialConfigurationFilter =
            CredentialConfigurationFilter { conf -> filters.all { it(conf) } }

    }
}