package view;

import entity.Compra;
import entity.Endereco;
import entity.Historico;
import entity.ItemComprado;
import entity.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import persist.ComprasDAO;
import persist.HistoricoDAO;
import persist.ProdutoDAO;
import util.TipoPagamento;
import util.UnidadeFederacao;

/**
 *
 * @author andre; arthur
 */
public class App {

    public static void main(String[] args) {
        
        HistoricoDAO hdao = HistoricoDAO.getInstance();
        
        ItemComprado itemComprado = new ItemComprado((Produto) ProdutoDAO.getInstance().read(18), 10, 20.20);
        ItemComprado itemComprado1 = new ItemComprado((Produto) ProdutoDAO.getInstance().read(19), 10, 20.20);
        ItemComprado itemComprado2 = new ItemComprado((Produto) ProdutoDAO.getInstance().read(20), 10, 20.20);
        ItemComprado itemComprado3 = new ItemComprado((Produto) ProdutoDAO.getInstance().read(21), 10, 20.20);
        
        Endereco enderecoEntrega = new Endereco("Local", "Brasil", "Cap", "Rua", "Rua vdd", 100, UnidadeFederacao.AMAPA);
        
        List<ItemComprado> itens = new ArrayList<>();
        
        itens.add(itemComprado);
        itens.add(itemComprado1);
        itens.add(itemComprado2);
        itens.add(itemComprado3);
        
        
        Compra c = new Compra(1, itens, 10.10, LocalDate.now(), false, TipoPagamento.DEBITO);
        
        ComprasDAO cdao = ComprasDAO.getInstance();
        
        cdao.create(c);
        
        
    }
}
