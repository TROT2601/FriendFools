package com.jeremy;

import com.jeremy.model.Client;
import com.jeremy.model.Doctor;
import com.jeremy.service.ClientService;
import com.jeremy.service.DoctorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AppClient implements CommandLineRunner {

    private final ClientService clientService;
    private final DoctorService doctorService;

    public AppClient(ClientService clientService, DoctorService doctorService) {
        this.clientService = clientService;
        this.doctorService = doctorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AppClient.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Client> clients = new ArrayList<>();
        Client client1 =
                new Client("CLI120","Jeremy","Aquino",72617193,"jr.Huancayo #584",972828932,"A+", LocalDate.of(1998,01,26),"jeremy10000ap@hotmail.com");
        clients.add(client1);
        Client client2 =
                new Client("CLI121","Renato","Solis",72625793,"jr.BelloHorizonte #2373",927819246,"O", LocalDate.of(1998,05,27),"raxo2705@hotmail.com");
        clients.add(client2);
        clientService.saveAll(clients);

        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor1 =
                new Doctor("DOC120","Jose","Nuñez",72947193,"jr.Huancayo #584",972828932,"A+", LocalDate.of(1998,01,26),"Urología","jose10000ap@hotmail.com");
        doctors.add(doctor1);
        Doctor doctor2 =
                new Doctor("DOC121","Ana","Aquino",72623713,"jr.BelloHorizonte #2373",927819246,"O", LocalDate.of(1998,05,27),"Traumatología","ana2705@hotmail.com");
        doctors.add(doctor2);
        doctorService.saveAll(doctors);
    }
}
