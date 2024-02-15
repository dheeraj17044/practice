package com.example.caching.service;

import com.example.caching.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import org.springframework.stereotype.Service;

@Service
public class MyCacheService {

    private final CacheManager cacheManager;

    @Autowired
    public MyCacheService(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    public void addDataInCache(int studentId, Student student){
        try{
            Cache studentCache = cacheManager.getCache("student_cache");
            if(studentCache!=null){
                studentCache.put(studentId,student);
            }
        }
        catch(Exception e){
            System.out.println("exception occured: -    " +e.toString());
        }
    }

    public Student getDataFromCache(int studentId){
        try{
            Cache studentCache = cacheManager.getCache("student_cache");
            if(studentCache!=null){
                return studentCache.get(studentId, Student.class);
            }
        }
        catch(Exception e){
            System.out.println("exception occured: -    " +e.toString());
        }
        return null;
    }

    public void deleteDataFromCache(int studentId){
        try{
            Cache studentCache = cacheManager.getCache("student_cache");
            if(studentCache!=null){
                studentCache.evict(studentId);
            }
        }
        catch(Exception e){
            System.out.println("exception occured: -    " +e.toString());
        }
    }
}
