package lab11.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class Leilao {
    private Produto produto;
    private double maiorLance;
    private Cliente maiorLicitador;
    private List<Observer> observers = new ArrayList<>();
    private Timer timer;

    public Leilao(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public Cliente getMaiorLicitador() {
        return maiorLicitador;
    }

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notificarObservers(String mensagem) {
        for (Observer observer : observers) {
            observer.update(mensagem);
        }
    }

    public void iniciarLeilao(int duracaoSegundos) {
        if (produto.getEstado() == EstadoProduto.STOCK) {
            produto.setEstado(EstadoProduto.LEILAO);
            notificarObservers("Leilão iniciado para o produto " + produto.getDescricao());
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    finalizarLeilao();
                }
            }, duracaoSegundos * 1000);
        }
    }

    public void licitar(Cliente cliente, double valor) {
        if (produto.getEstado() == EstadoProduto.LEILAO && valor > maiorLance) {
            maiorLance = valor;
            maiorLicitador = cliente;
            notificarObservers(cliente.getNome() + " fez uma licitação de " + valor + " para o produto " + produto.getDescricao());
        }
    }

    private void finalizarLeilao() {
        if (maiorLicitador != null) {
            produto.setEstado(EstadoProduto.VENDAS);
            notificarObservers("Leilão finalizado. Produto " + produto.getDescricao() + " vendido para " + maiorLicitador.getNome() + " por " + maiorLance);
        } else {
            produto.setEstado(EstadoProduto.STOCK);
            notificarObservers("Leilão finalizado. Produto " + produto.getDescricao() + " não teve licitações e voltou ao stock");
        }
        if (timer != null) {
            timer.cancel();
        }
    }
}

