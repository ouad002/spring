package com.emse.spring.automacorp;

import com.emse.spring.automacorp.WindowEntity;
import com.emse.spring.automacorp.WindowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api/windows")
public class WindowController {

    @Autowired
    private WindowDao windowDao;

    @Operation(summary = "Retrieve all windows")
    @GetMapping
    public List<WindowEntity> getAllWindows() {
        return windowDao.findAll();
    }

    @Operation(summary = "Retrieve a window by ID")
    @GetMapping("/{id}")
    public ResponseEntity<WindowEntity> getWindowById(@PathVariable Long id) {
        return windowDao.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Create a new window")
    @PostMapping
    @Transactional
    public WindowEntity createWindow(@RequestBody WindowEntity window) {
        return windowDao.save(window);
    }

    @Operation(summary = "Update a window")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<WindowEntity> updateWindow(@PathVariable Long id, @RequestBody WindowEntity windowDetails) {
        return windowDao.findById(id)
                .map(window -> {
                    window.setName(windowDetails.getName());
                    window.setWindowStatus(windowDetails.getWindowStatus());
                    window.setRoom(windowDetails.getRoom());
                    windowDao.save(window);
                    return ResponseEntity.ok(window);
                })
                .orElse(ResponseEntity.notFound().build());
    }



    @Operation(summary = "Delete a window by name")
    @DeleteMapping("/name/{name}")
    @Transactional
    public ResponseEntity<Void> deleteWindowByName(@PathVariable String name) {
        windowDao.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}

// demo github actions workflow for multiple java versions


