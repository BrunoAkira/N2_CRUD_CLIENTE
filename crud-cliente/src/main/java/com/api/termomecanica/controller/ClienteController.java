package com.api.termomecanica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.api.termomecanica.bean.ClienteBean;
import com.api.termomecanica.dao.ClienteDAO;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDAO;

	/**
	 * Metodo de inicializacao da pagina
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/cliente")
	public String startPage(Model model) {
		initialize(model);
		return "cliente";
	}

	/**
	 * Inicializa as variaveis da tela
	 *
	 * @param model
	 */
	private void initialize(Model model) {
		try {

			// trazer a lista de clientes do banco

			List<ClienteBean> clientes = new ArrayList<ClienteBean>();
			ClienteDAO c = new ClienteDAO();
			clientes = c.getAllCliente();

			// lista manual sem pesquisar no banco, soh para testes
			// clientes.add(new ClienteBean("Bruno", "akira@hotmail.com"));
			// clientes.add(new ClienteBean("Bruno", "bruno@hotmail.com"));

			model.addAttribute("clientes", clientes);

		} catch (Exception e) {
			System.out.println("Erro ao carregar a pagina de Cliente!");
		}
	}

	/**
	 * Cadastra Cliente
	 *
	 * @param ClienteBean : Cliente a ser cadastrado
	 * @return
	 */
	@RequestMapping(value = "crud_cliente", params = "cadastrar", method = RequestMethod.POST)
	public String cadastrarCliente(ClienteBean cliente, RedirectAttributes redirectAttrs) {
		
		try {

			System.out.println("cliente a ser cadastrado: " + cliente.toString());

			if (cliente.getCpf() != null) {
				// chama o dao para salvar o cliente
				clienteDAO.addCliente(cliente);
				redirectAttrs.addFlashAttribute("msg", "Cliente " + cliente.getNome() +  " cadastrado com sucesso");
			}else {
				redirectAttrs.addFlashAttribute("msg", "Necessario Incluir CPF");
			}

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("msg", "Falha ao Cadastrar Cliente " + cliente.getNome() );

			System.out.println("Erro ao cadastrar Cliente!");
		} // end try/catch

		return "redirect:cliente";
	}

	/**
	 * Atualiza Cliente
	 *
	 * @param ClienteBean : Cliente a ser atualizado
	 * @return
	 */
	@RequestMapping(value = "crud_cliente", params = "atualizar", method = RequestMethod.POST)
	public String atualizarCliente(ClienteBean cliente, RedirectAttributes redirectAttrs) {

		try {

			System.out.println("cliente a ser atualizado: " + cliente.toString());

			// chama o dao para salvar o cliente
			clienteDAO.atualizaCliente(cliente);
			redirectAttrs.addFlashAttribute("msg", "Cliente " + cliente.getNome() +  " atualizado com sucesso");

		} catch (Exception e) {
			System.out.println("Erro ao atualizar Cliente!");
			redirectAttrs.addFlashAttribute("msg", "Falha ao Atualizar Cliente " + cliente.getNome());

		} // end try/catch

		return "redirect:cliente";
	}

	/**
	 * Deletar Cliente
	 *
	 * @param ClienteBean : Cliente a ser deletado
	 * @return
	 */
	@RequestMapping(value = "crud_cliente", params = "deletar", method = RequestMethod.POST)
	public String deletarCliente(ClienteBean cliente, RedirectAttributes redirectAttrs) {

		try {

			System.out.println("cliente a ser deletado: " + cliente.toString());

			// chama o dao para salvar o cliente
			clienteDAO.deleteCliente(cliente.getId());
			redirectAttrs.addFlashAttribute("msg", "Cliente " + cliente.getNome() +  " deletado com sucesso");

		} catch (Exception e) {
			System.out.println("Erro ao deletar Cliente!");
			redirectAttrs.addFlashAttribute("msg", "Falha ao deletar Cliente " + cliente.getNome());

		} // end try/catch

		return "redirect:cliente";
	}
	
}
