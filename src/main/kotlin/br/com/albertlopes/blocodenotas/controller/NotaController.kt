package br.com.albertlopes.blocodenotas.controller

import br.com.albertlopes.blocodenotas.model.Nota
import br.com.albertlopes.blocodenotas.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/nota")
class NotaController {


    @Autowired
    lateinit var notaService: NotaService

    @GetMapping("/check")
    fun checkHealth(): String {

        return "ok"
    }

    @GetMapping()
    fun buscarTodos(): List<Nota> {
        return notaService.buscarTodos()
    }

    @PostMapping()
    fun buscarTodos(@RequestBody nota: Nota): Nota {
        return notaService.salvar(nota)

    }

    @DeleteMapping("/{id}")
    fun apagar(@PathVariable("id") id: String) {
        notaService.apagar(id)
    }

    @GetMapping("/{id}")
    fun buscar(@PathVariable("id") id: String): Nota {
      return  notaService.buscarPorId(id)
    }

    @GetMapping("/titulo/{titulo}")
    fun buscarPorTitulo(@PathVariable("titulo") titulo: String): List<Nota> {
        return  notaService.buscarPorTitulo(titulo)
    }


}
