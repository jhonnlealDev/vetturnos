public class Cliente {
    public Cliente(String panelInicio ) {
        super(panelInicio);
    }

    @Override
    public String panelInicio() {
        return "Panel de Cliente: ver productos y mis compras";
    }
}
