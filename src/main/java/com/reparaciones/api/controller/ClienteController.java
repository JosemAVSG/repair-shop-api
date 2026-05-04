package com.reparaciones.api.controller;

import com.reparaciones.domain.model.Cliente;
import com.reparaciones.domain.repository.ClienteRepository;
import com.reparaciones.api.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ApiResponse<List<ClienteResponse>> getAll() {
        List<ClienteResponse> clientes = clienteRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
        return ApiResponse.success(clientes);
    }

    @GetMapping("/{id}")
    public ApiResponse<ClienteResponse> getById(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(c -> ApiResponse.success(toResponse(c)))
                .orElse(ApiResponse.error("Cliente no encontrado"));
    }

    @PostMapping
    public ApiResponse<ClienteResponse> create(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setTelefono(request.getTelefono());
        cliente.setEmail(request.getEmail());
        cliente.setCreatedBy("system");

        Cliente saved = clienteRepository.save(cliente);
        return ApiResponse.success(toResponse(saved));
    }

    @PutMapping("/{id}")
    public ApiResponse<ClienteResponse> update(@PathVariable Long id, @Valid @RequestBody ClienteRequest request) {
        return clienteRepository.findById(id)
                .map(c -> {
                    c.setNombre(request.getNombre());
                    c.setTelefono(request.getTelefono());
                    c.setEmail(request.getEmail());
                    return ApiResponse.success(toResponse(clienteRepository.save(c)));
                })
                .orElse(ApiResponse.error("Cliente no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        if (clienteRepository.findById(id).isPresent()) {
            clienteRepository.deleteById(id);
            return ApiResponse.success(null);
        }
        return ApiResponse.error("Cliente no encontrado");
    }

    private ClienteResponse toResponse(Cliente c) {
        ClienteResponse r = new ClienteResponse();
        r.setId(c.getId());
        r.setNombre(c.getNombre());
        r.setTelefono(c.getTelefono());
        r.setEmail(c.getEmail());
        r.setCreatedAt(c.getCreatedAt());
        return r;
    }
}