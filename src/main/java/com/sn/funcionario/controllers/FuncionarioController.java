package com.sn.funcionario.controllers;

import com.sn.funcionario.models.FuncionarioModel;
import com.sn.funcionario.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioModel> findAll() {
        return funcionarioService.findAll();
    }

    @GetMapping("/{id}")
    public FuncionarioModel buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscaporId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        funcionarioService.deletar(id);
    }

    @PostMapping
    public FuncionarioModel criarFuncionario(@RequestBody FuncionarioModel funcionarioModel){
        return funcionarioService.criarPessoa(funcionarioModel);
    }

    @PutMapping("/{id}")
    public FuncionarioModel atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel){
        return funcionarioService.atualizar(id, funcionarioModel);
    }
}
