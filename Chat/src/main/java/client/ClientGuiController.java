package client;

public class ClientGuiController extends Client {
        private ClientGuiModel clientGuiModel = new ClientGuiModel();
        private ClientGuiView clientGuiView = new ClientGuiView(this);

        public class GuiSocketThread extends SocketThread{

            protected void processIncomingMessage(String message){
                clientGuiModel.setNewMessage(message);
                clientGuiView.refreshMessages();}

            private void informAboutAddingNewUser(String userName){
                clientGuiModel.addUser(userName);
                clientGuiView.refreshUsers();}

            protected void informAboutDeletingNewUser(String userName){
                clientGuiModel.deleteUser(userName);
                clientGuiView.refreshUsers();}

            protected void notifyConnectionStatusChanged(boolean clientConnected){
                super.notifyConnectionStatusChanged(clientConnected);
                clientGuiView.notifyConnectionStatusChanged(clientConnected);}}

        protected SocketThread getSocketThread(){
            return new GuiSocketThread();}

        @Override
        public void run() {
            getSocketThread().run();}

        @Override
        protected String getServerAddress() {
            return clientGuiView.getServerAddress();}

        @Override
        protected int getServerPort() {
            return clientGuiView.getServerPort();}

        @Override
        protected String getUserName() {
            return clientGuiView.getUserName();}

        public ClientGuiModel getModel(){
            return clientGuiModel;}


        public static void main(String[] args) {
            ClientGuiController clientGuiController = new ClientGuiController();
            clientGuiController.run();}}


