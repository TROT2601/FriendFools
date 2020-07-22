package com.jeremy.resource;

import com.jeremy.model.Client;
import com.jeremy.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientResource {

    private final ClientService clientService;

    public ClientResource(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public ResponseEntity findAll(){
        List<Client> clients = clientService.findAll();
        if (clients == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/{codClient}")
    public ResponseEntity findByCodClient(@PathVariable String codClient){
        Client cClient = clientService.findById(codClient);
        if (cClient == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cClient, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity create(@RequestBody Client client){
        clientService.create(client);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/clients/{codClient}")
    public ResponseEntity update(@PathVariable String codClient,
                                  @RequestBody Client client){
        Client cClient = clientService.findById(codClient);
        if (cClient == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        client.setCodClient(codClient);
        clientService.update(client);
        return new ResponseEntity(client,HttpStatus.OK);
    }

    @DeleteMapping("/clients/{codCliente}")
    public ResponseEntity delete(@PathVariable String codClient,
                                 @RequestBody Client client){
        Client cClient = clientService.findById(codClient);
        if (cClient == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        client.setCodClient(codClient);
        clientService.delete(client);
        return new ResponseEntity(client,HttpStatus.OK);
    }


}
