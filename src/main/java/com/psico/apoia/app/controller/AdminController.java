package com.psico.apoia.app.controller;

import com.psico.apoia.app.common.Admin;
import com.psico.apoia.app.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping(value = "/criar", produces = "application/json")
    public Admin criarAdmin(@RequestBody final Admin admin) {
        return adminService.criarAdmin(admin);
    }

    @PutMapping(value = "/atualizar", produces = "application/json")
    public Admin atualizarAdmin(@RequestBody final Admin admin) {
        return adminService.atualizarAdmin(admin);
    }

    @DeleteMapping(value = "/{cpf}", produces = "application/json")
    public void deletarAdmin(@PathVariable("email") String email) {
        adminService.deletarAdmin(email);
    }

    @GetMapping(value = "/{email}", produces = "application/json")
    public List<Admin> obterAdminPorEmail(@PathVariable("email") String email) {
        return adminService.obterAdminPorEmail(email);
    }

    @GetMapping(value = "/{nome}", produces = "application/json")
    public List<Admin> obterAdminPorNome(@PathVariable("nome") String nome) {
        return adminService.obterAdminPorNome(nome);
    }

}
