package com.example.crud.controllers;

import com.example.crud.model.Model;
import com.example.crud.repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controllers {

    @Autowired
    private DataRepo repo;

    @GetMapping("/getdata")
    public List<Model> get()
    {
        return repo.findAll();
    }

    @PostMapping("/postdata")
    public String post(@RequestBody Model data ){
        repo.save(data);
        return "Data have been added successfully";
    }

    @DeleteMapping("/deletedata/{emp_id}")
    public String delete(@PathVariable int emp_id)
    {
        repo.deleteById(emp_id);
        return "Deleted successfully";
    }

    @PutMapping("/updatedata")
    public String updateName(@RequestBody Model updatedData) {
        Optional<Model> existingData = repo.findById(updatedData.getEmp_id());
            Model dataToUpdate = existingData.get();
            dataToUpdate.setName(updatedData.getName());
            repo.save(dataToUpdate);
            return "Data updated successfully";
    }
}
