package com.github.dataanon.strategy.number

import com.github.dataanon.model.Field
import com.github.dataanon.model.Record
import com.github.dataanon.strategy.AnonymizationStrategy
import com.github.dataanon.utils.RandomUtils

class RandomFloatDelta(private val delta: Float = 10.0f) : AnonymizationStrategy<Float> {

    override fun anonymize(field: Field<Float>, record: Record): Float {

        val adjustment = if ( delta < 0 ) RandomUtils.generateRandomFloat(from = delta, to = -delta)
                         else             RandomUtils.generateRandomFloat(from = -delta,  to = delta)

        return field.oldValue + adjustment
    }
}