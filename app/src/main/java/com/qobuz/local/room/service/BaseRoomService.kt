package com.qobuz.local.room.service

import com.qobuz.local.room.dao.BaseDao

abstract class BaseRoomService<T>(val baseDao: BaseDao<T>) {

    open fun upsert(t: T) {
        baseDao.upsert(t)
    }

    open fun upsertLists(t: List<T>) {
        baseDao.upsert(t)
    }

    open fun delete(t: T) {
        baseDao.delete(t)
    }

    abstract fun deleteById(id: String)
}