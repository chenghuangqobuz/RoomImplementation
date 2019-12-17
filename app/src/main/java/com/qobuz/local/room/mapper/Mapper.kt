package com.qobuz.local.room.mapper

interface Mapper<Model, Entity> {

    fun mapTo(model: Model): Entity

    fun mapFrom(entity: Entity): Model
}