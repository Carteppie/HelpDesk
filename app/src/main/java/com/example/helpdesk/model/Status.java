package com.example.helpdesk.model;

public enum Status {
    ENVIADA{
        @Override
        public String toString(){
            return "Enviada";
        }
    },
    NAOENVIADA{
        @Override
        public String toString(){
            return "Não Enviada";
        }
    }
}
