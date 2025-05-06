# Simulazione di un Aeroporto

---

## 1. Introduzione

### Contesto e motivazione  
Il progetto ha l'obiettivo di simulare le operazioni di un aeroporto, gestendo il movimento degli aerei tra hangar, aree di sosta e piste, insieme a rifornimenti, gestione bagagli e controllo della concorrenza. Il sistema garantisce la sincronizzazione tra risorse limitate (piste, aree di sosta) e veicoli di servizio.

### Obiettivi del progetto  
- Sviluppare classi per aerei, aree dedicate e veicoli di servizio.  
- Gestire la concorrenza tramite semafori per evitare conflitti su risorse condivise.  
- Simulare il ciclo di vita di un aereo: partenza, atterraggio, rifornimento e gestione bagagli.  

### Organizzazione del gruppo di sviluppo  
- **Matteo Querini**: Implementa le classi `AreaSosta`, `Constants`, `Semaforo`, `VeicoloServizioBagagli`, `VeicoloServizioRifornimento`.  
- **Riccardo Graffi**: Implementa le classi `Aereo`, `Aeroporto`, `Hangar`, `Pista`.  

---

## 2. Analisi dei requisiti

### Requisiti funzionali  
- Aggiunta/rimozione aerei dall'aeroporto.  
- Controllo capacità: hangar (max 5 aerei), area di sosta (max 3 aerei).  
- Decollo consentito solo con: serbatoio pieno, bagagli sotto il peso massimo, pista libera.  
- Atterraggio su piste e aree di sosta.  
- Operazioni di carico/scarico bagagli e rifornimento gestite da veicoli dedicati.  

### Requisiti non funzionali  
- **Concorrenza**: Semafori per gestire l'accesso a risorse condivise.  
- **Usabilità**: Messaggi colorati (verde/rosso) per feedback visivo.  

### Tecnologie e strumenti  
- **Linguaggio**: Java  
- **Strumenti**: Semafori per sincronizzazione, GitHub per versionamento.  

---

## 3. Progettazione

### Architettura del sistema  
- **Classi principali**:  
  - `Aereo`: Modella gli attributi dell'aereo.  
  - `Aeroporto`: Coordina hangar, area di sosta, piste, decollo/atterraggio.  
  - `VeicoloServizioBagagli` e `VeicoloServizioRifornimento`: Operazioni su bagagli e carburante.  
  - `Hangar`, `AreaSosta`, `Pista`: Aree dedicate.  

### Design dell'interfaccia  
- Interfaccia a riga di comando con output testuale colorato (es. "Aereo decollato" in verde).  

---

## 4. Implementazione

### Problemi riscontrati  
- **Concorrenza**: Deadlock in `gestisciDecollo` risolto con rilascio semaforo post-operazione.  
- **Errori nel codice**:  
  - Sincronizzazione delle operazioni sugli aerei.  
  - Gestione del decollo.  

---

## 5. Test e validazione

### Tipi di test  
- **Test manuali**:  
  - Decollo con pista occupata → Messaggio "Pista occupata".  
  - Carico bagagli oltre limite → Messaggio "Caricare l'aereo con meno bagagli".  
- Verifica stati aerei (es. "in area di sosta" → "preparazione al decollo").  

### Risultati  
- **Funzionanti**: Aggiunta/rimozione aerei, controllo capacità aree.  
- **Da migliorare**: Gestione aerei in volo (aggiunta lista dedicata).  

---

## 6. Conclusioni e sviluppi futuri

### Conclusioni  
- Collaborazione efficace nonostante la complessità.  
- Apprendimento: Semafori avanzati in Java e utilizzo di GitHub.  

### Implementazioni future  
- Interfaccia grafica per visualizzazione stato aeroporto in tempo reale.  

---

## 7. Bibliografia e risorse  
- [Repository GitHub](https://github.com/matteoQuerini/Raianer)  
- Documentazione Java  
- W3School  
