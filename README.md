# Monitoramento de Rios da Amazônia - PCDs e Universidades

Sistema baseado no padrão de projeto **Observer** para coletar e distribuir dados ambientais de rios da Amazônia.  
Plataformas de Coleta de Dados (PCDs) monitoram parâmetros como temperatura da água, pH, nível do rio e umidade do ar.  
Universidades podem se inscrever para receber notificações automáticas sempre que um dado é atualizado.

## Visão Geral do projeto

- **Sujeito (Observable)**: `PCD` (Plataforma de Coleta de Dados) – armazena dados do rio e gerencia observadores.
- **Observadores (Observers)**: `Universidades` (e qualquer outra classe que implemente `Observer`) – reagem às mudanças.
- **Notificação**: Sempre que um atributo da PCD muda (temperatura, pH, etc.), todos os observadores inscritos são avisados via método `update()`.
