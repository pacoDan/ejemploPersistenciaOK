package Incidentes;

public class WhatsappTecnico implements EstrategiaNotificacionTecnicos {

        private AdapterNotificacionWhatsappTecnico adapter;

        public WhatsappTecnico(AdapterNotificacionWhatsappTecnico adapter) {
            this.adapter = adapter;
        }

        @Override
        public void notificar(NotificacionTecnico notificacion) {
            adapter.notificar(notificacion);

}
}
