package com.qobuz.local.room.dao

import androidx.room.*

@Dao
abstract class BaseDao<T> {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     * @return The SQLite row id
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: T): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     * @return The SQLite row ids
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insert(obj: List<T>): List<Long>

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    abstract fun update(obj: T)

    /**
     * Update an array of objects from the database.
     *
     * @param obj the object to be updated
     */
    @Update
    abstract fun update(obj: List<T>)

    /**
     * Delete an object from the database
     *
     * @param obj the object to be deleted
     */
    @Delete
    abstract fun delete(obj: T)

    @Transaction
    open fun upsert(obj: T, onPreUpdate: ((T) -> Unit)? = null) {
        val id = insert(obj)
        if (id == -1L) {
            onPreUpdate?.invoke(obj)
            update(obj)
        }
    }

    @Transaction
    open fun upsert(objList: List<T>, onPreUpdate: ((List<T>) -> Unit)? = null) {
        val insertResult = insert(objList)
        val updateList = ArrayList<T>()

        insertResult.forEachIndexed { index, result ->
            if(result == -1L)
                updateList.add(objList[index])
        }

        if (!updateList.isEmpty()) {
            onPreUpdate?.invoke(updateList)
            update(updateList)
        }
    }
}