package com.example.Portfolio_Backend.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.Portfolio_Backend.entity.ContactForm;
public interface ContactRepository extends MongoRepository<ContactForm, String> {

}
