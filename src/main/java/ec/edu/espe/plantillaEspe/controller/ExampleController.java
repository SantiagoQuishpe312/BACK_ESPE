package ec.edu.espe.plantillaEspe.controller;

import ec.edu.espe.plantillaEspe.model.ModelExample;
import ec.edu.espe.plantillaEspe.service.IServiceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static ec.edu.espe.plantillaEspe.constant.GlobalConstants.V1_API_VERSION;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(V1_API_VERSION+"/example")
public class ExampleController {

    @Autowired
    private IServiceExample serviceExample;

    @GetMapping("/exampleFindId")
    public ResponseEntity<ModelExample> find(@RequestParam Long id) {
        return new ResponseEntity<>(serviceExample.find(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ModelExample>> findAll() {
        return new ResponseEntity<>(serviceExample.findAll(), HttpStatus.OK);
    }
}
