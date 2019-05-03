/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Modal.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */

    @WebFilter(filterName = "AutorizacaoFilter", servletNames = { "HomeProtegidoServlet" }, 
        urlPatterns = { "/protegido/*" })
    
    public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(
                ServletRequest request,
                ServletResponse response,
                FilterChain chain) throws IOException, ServletException {
        // CAST para objetos do tipo HttpServlet*
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verifica se usuario ja esta logado
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("usuario") == null) {
            // Redirecionar para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        // Verifica se o usuário possui o papel para acessar funcionalidade.
        UsuarioSistema usuario = (Usuario) sessao.getAttribute("usuario");

        if (verificarAcesso(usuario, httpRequest, httpResponse)) {
            // Requisicao pode seguir para o Servlet
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro-nao-autorizado.jsp");
        }
    }

    private boolean verificarAcesso(UsuarioSistema usuario,
            HttpServletRequest request,
            HttpServletResponse response) {
        String paginaAcessada = request.getRequestURI();
        if (paginaAcessada.endsWith("/protegido/home")) {
            return true;
        } else if (paginaAcessada.endsWith("/protegido/peao-page")
                && usuario.verificarPapel("PEAO")) {
            return true;
        } else if (paginaAcessada.endsWith("/protegido/fodon-page")
                && usuario.verificarPapel("FODON")) {
            return true;
        } else if (paginaAcessada.endsWith("/protegido/god-page")
                && usuario.verificarPapel("GOD")) {
            return true;
        }

        return false;
    }
}


