package persist;

import entity.Pessoa;
import entity.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import util.TipoUsuario;

/**
 *
 * @author andre; arthur
 */
public class PessoaDAO implements DAO {

    private static PessoaDAO pdao;
    private static Connection conexao;

    public static PessoaDAO getInstance() {
        if (pdao == null) {
            pdao = new PessoaDAO();
        }
        return pdao;
    }

    private PessoaDAO() {
        ConexaoBD conexaoBD;

        try {
            conexaoBD = ConexaoBD.getInstance();
            conexao = ConexaoBD.getConexao();
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro = " + ex);
        } catch (SQLException ex) {
            //Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro = " + ex);
        }

    }

    @Override
    public boolean create(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Pessoa) {
            Pessoa p = (Pessoa) obj;
            String nome = p.getNome();
            String cpf = p.getCpf();
            String dataNascimento = p.getDataNascimentoString();
            String email = p.getUser().getLogin();
            String senha = p.getUser().getSenha();
            Enum tipo = p.getUser().getTipoUsuario();
            int tipoUser = tipo.ordinal();
            String sql = "INSERT INTO usuarios (cpf, email, data_nascimento, nome, senha, tipo)"
                    + "VALUES ( ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(1, cpf);
                pstmt.setString(3, dataNascimento);
                pstmt.setString(2, email);
                pstmt.setString(4, nome);
                pstmt.setString(5, senha);
                pstmt.setInt(6, tipoUser);
                pstmt.executeUpdate();
                return true;
            } catch (SQLException sqe) {
                System.out.println("Erro = " + sqe);
            }
        }
        return false;
    }

    @Override
    //Em obj estará o cpf
    public Object read(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof String) {
            try {
                String cpf = (String) obj;
                String sql = "SELECT * FROM usuarios WHERE cpf = '" + cpf + "'";
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String email =  rs.getString(2);
                    String data = rs.getString(3);
                    String nome = rs.getString(4);
                    String senha = rs.getString(5);
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataNascimento = LocalDate.parse(data, formato);
                    int tipo = rs.getInt(6);
                    Enum tipoUser = TipoUsuario.COMUN;
                    if (tipo != 0) {
                        tipoUser = TipoUsuario.ADMIN;
                    }
                    Usuario user = new Usuario(email, senha);
                    user.setTipoUsuario(tipoUser);
                    Pessoa p = new Pessoa(cpf, nome, dataNascimento);
                    p.setUser(user);
                    return p;
                }
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return null;
    }

    @Override
    public boolean update(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof Pessoa) {
            try {
                Pessoa p = (Pessoa) obj;
                String sql = "UPDATE usuarios SET email = ?, data_nascimento = ?, nome = ?, senha = ?, tipo = ? WHERE cpf = ?";
                PreparedStatement pstmt = conexao.prepareStatement(sql);
                pstmt.setString(3, p.getNome());
                pstmt.setString(2, p.getDataNascimentoString());
                pstmt.setString(1, p.getUser().getLogin());
                pstmt.setString(4, p.getUser().getSenha());
                pstmt.setInt(5, p.getUser().getTipoUsuario().ordinal());
                pstmt.setString(6, p.getCpf());
                pstmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        Objects.requireNonNull(obj);
        if (obj instanceof String) {
            try {
                String cpf = (String) obj;
                String sql = "DELETE FROM usuarios WHERE cpf = '" + cpf + "'";
                Statement stmt = conexao.createStatement();
                int nreg = stmt.executeUpdate(sql);
                if (nreg > 0) {
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex);
            }
        }
        return false;
    }
    
    public List<Pessoa> listarPessoasPorTipo(int tipoUsuario) {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE tipo = ?";
        try {
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, tipoUsuario);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String data = rs.getString("data_nascimento");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                int tipo = rs.getInt("tipo");

                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(data, formato);

                Enum tipoUser = TipoUsuario.COMUN;
                if (tipo != 0) {
                    tipoUser = TipoUsuario.ADMIN;
                }

                Usuario user = new Usuario(email, senha);
                user.setTipoUsuario(tipoUser);
                Pessoa p = new Pessoa(cpf, nome, dataNascimento);
                p.setUser(user);

                pessoas.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex);
        }

        return pessoas;
    }

}
