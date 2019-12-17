package com.qobuz.local.service

import com.qobuz.local.room.dao.BaseDao

abstract class BaseService<T>(val baseDao: BaseDao<T>) {

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