package com.produtos.apiRest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apiRest.models.Produto;
import com.produtos.apiRest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/api" )
@Api(value="API REST PRODUCTOS")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Recuperar listado")
    public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	

	@GetMapping("/produto/{id}")
	@ApiOperation(value="Recuperar producto")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
	
	@PostMapping("/produto")
	@ApiOperation(value="Guardar")
	public Produto salvarProduto(@RequestBody Produto produto) {
	return produtoRepository.save(produto);
	  }
	
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Borrar")
	public void deletaProduto(@RequestBody Produto produto) {
	produtoRepository.delete(produto);
	  }
	
	
	@PutMapping("/produto")
	@ApiOperation(value="Actualizar")
	public Produto atualizaProduto(@RequestBody Produto produto) {
	return produtoRepository.save(produto);
	  }
	
	
	
	
}

