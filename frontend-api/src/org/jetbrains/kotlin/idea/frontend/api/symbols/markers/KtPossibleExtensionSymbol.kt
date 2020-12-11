/*
 * Copyright 2010-2020 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.idea.frontend.api.symbols.markers

import org.jetbrains.kotlin.idea.frontend.api.symbols.KtCallableSymbol
import org.jetbrains.kotlin.idea.frontend.api.types.KtType

data class ReceiverTypeAndAnnotations(val type: KtType, val annotations: List<KtAnnotationCall>)

interface KtPossibleExtensionSymbol {
    val receiverTypeAndAnnotations: ReceiverTypeAndAnnotations?
    val isExtension: Boolean
}

val KtCallableSymbol.isExtension: Boolean
    get() = (this as? KtPossibleExtensionSymbol)?.isExtension == true
