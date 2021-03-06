package com.moony.mvvmstudyrecordapp.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SubjectRepository @Inject constructor(private val subjectDao:SubjectDao) {

    fun getAllSubject(): Flow<List<Subject>> {
        return subjectDao.getAllSubject()
    }
    suspend fun insertSubject(subject:Subject){
        subjectDao.insert(subject)
    }
    suspend fun deleteSubject(subject: Subject){
        subjectDao.delete(subject)
    }

    fun getSubjectByName(name:String): Flow<Subject> {
        return subjectDao.getSubjectByName(name)
    }

    suspend fun updateSubject(subject: Subject){
        subjectDao.updateSubject(subject)
    }



}