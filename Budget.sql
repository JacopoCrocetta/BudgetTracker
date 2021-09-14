CREATE TABLE `entrate_annuali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE
  );

CREATE TABLE `salario`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `entrateid`        INT,
     `data_inserimento` DATE
  );

CREATE TABLE `altro_salario`
  (
     `id`              INT PRIMARY KEY auto_increment,
     `idsalario`       INT,
     `totale_mensile`  BIGINT,
     `data_insermento` DATE,
     `data_spesa`      DATE,
     `descrizione`     VARCHAR(255)
  );

CREATE TABLE `bonus`
  (
     `id`              INT PRIMARY KEY auto_increment,
     `idsalario`       INT,
     `totale_mensile`  BIGINT,
     `data_insermento` DATE,
     `data_spesa`      DATE,
     `descrizione`     VARCHAR(255)
  );

CREATE TABLE `busta_paga`
  (
     `id`              INT PRIMARY KEY auto_increment,
     `idsalario`       INT,
     `totale_mensile`  BIGINT,
     `data_insermento` DATE,
     `data_spesa`      DATE,
     `descrizione`     VARCHAR(255)
  );

CREATE TABLE `commissioni`
  (
     `id`              INT PRIMARY KEY auto_increment,
     `idsalario`       INT,
     `totale_mensile`  BIGINT,
     `data_insermento` DATE,
     `data_spesa`      DATE,
     `descrizione`     VARCHAR(255)
  );

CREATE TABLE `mance`
  (
     `id`              INT PRIMARY KEY auto_increment,
     `idsalario`       INT,
     `totale_mensile`  BIGINT,
     `data_insermento` DATE,
     `data_spesa`      DATE,
     `descrizione`     VARCHAR(255)
  );

CREATE TABLE `altre_entrate`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `entrateid`        INT,
     `data_inserimento` DATE
  );

CREATE TABLE `altre_entrate_ae`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `id_altre_entrate` INT,
     `totale_mensile`   BIGINT,
     `data_insermento`  DATE,
     `data_spesa`       DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `dividendi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `id_altre_entrate` INT,
     `totale_mensile`   BIGINT,
     `data_insermento`  DATE,
     `data_spesa`       DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `interessi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `id_altre_entrate` INT,
     `totale_mensile`   BIGINT,
     `data_insermento`  DATE,
     `data_spesa`       DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `regali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `id_altre_entrate` INT,
     `totale_mensile`   BIGINT,
     `data_insermento`  DATE,
     `data_spesa`       DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `rimborsi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `id_altre_entrate` INT,
     `totale_mensile`   BIGINT,
     `data_insermento`  DATE,
     `data_spesa`       DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `trasferimenti_risparmi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `id_altre_entrate` INT,
     `totale_mensile`   BIGINT,
     `data_insermento`  DATE,
     `data_spesa`       DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altre_uscite`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `animali_domestici`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `alimenti_animali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idanimali`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_animali_domestici`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idanimali`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `forniture_animali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idanimali`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `giocattoli_animali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idanimali`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `veterinario_animali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idanimali`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `assicurazione`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altre_assicurazioni`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idassicurazione`  INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `assicurazione_auto`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idassicurazione`  INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `assicurazione_casa`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idassicurazione`  INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `assicurazione_salute`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idassicurazione`  INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `assicurazione_vita`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idassicurazione`  INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altre_bollette`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_acqua`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_elettricita`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_gas`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_internet`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_rifiuti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_telefono`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollette_tv`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idbollette`       INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `casa`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `affitto`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_casa`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `arredamento`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `forniture_casa`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `giardinaggio`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `imposte_immobiliari`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `manutenzione_casa`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `miglioramenti_casa`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `trasloco`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idcasa`           INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `debiti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altri_prestiti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddebiti`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_debito`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddebiti`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `carte_credito`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddebiti`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `imposte_locali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddebiti`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `imposte_statali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddebiti`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `prestiti_studio`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddebiti`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `divertimento`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_divertimento`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `attivita_outside`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `concerti_spettacoli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `film`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `fotografia`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `hobby`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `libri_divertimento`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `musica`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `partite`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `sport`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `teatro`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `tv_divertimento`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iddivertimento`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `asilo`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `attivita_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `giocattoli_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `paghetta_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `scuola_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `spese_mediche_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `vestiti_figli`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idfigli`          INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `istruzione`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_istruzione`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idistruzione`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `lezioni_indipendenti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idistruzione`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `libri_istruzione`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idistruzione`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `rette_istruzione`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idistruzione`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `regali_uscite`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_regali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idregaliuscite`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `donazioni_benefiche`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idregaliuscite`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `regali_t`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idregaliuscite`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `spese_mediche`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_spese_mediche`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idspesemediche`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `cure_specialistiche`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idspesemediche`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `dottori`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idspesemediche`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `emergenze`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idspesemediche`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `farmaci`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idspesemediche`   INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `spese_quotidiane`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `abbonamenti`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `altro_spese_quotidiane`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `igiene_personale`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `lavanderia`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `parrucchiere`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `ristoranti`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `supermercati`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `vestiti_spese_quotidiane`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `idspesequotidiane` INT,
     `data_spesa`        DATE,
     `data_inserimento`  DATE,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `tecnologia`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_tecnologia`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtecnologia`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `hardware`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtecnologia`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `servizi_hosting`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtecnologia`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `serizi_online`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtecnologia`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `software`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtecnologia`     INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `trasporti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_trasporti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `bollo`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `carburante`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `forniture_trasporti`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `prestiti_auto`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `riparazioni_auto`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `trasporto_pubblico`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idtrasporti`      INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `altro_viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idviaggio`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `alimenti_viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idviaggio`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `biglietti_aerei_viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idviaggio`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `divertimento_viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idviaggio`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `hotel_viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idviaggio`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `trasporto_viaggi`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `idviaggio`        INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `entrate_mensili`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE
  );

CREATE TABLE `entrate_mensili_effettive`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `identratemensile` INT,
     `data_inserimento` DATE
  );

CREATE TABLE `risparmi_effettivi`
  (
     `id`                 INT PRIMARY KEY auto_increment,
     `identrataeffettiva` INT,
     `data_inserimento`   DATE,
     `totale_mensile`     BIGINT
  );

CREATE TABLE `busta_paga_effettivi`
  (
     `id`                 INT PRIMARY KEY auto_increment,
     `identrataeffettiva` INT,
     `data_inserimento`   DATE,
     `totale_mensile`     BIGINT,
     `descrizione`        VARCHAR(255)
  );

CREATE TABLE `bonus_effettivi`
  (
     `id`                 INT PRIMARY KEY auto_increment,
     `identrataeffettiva` INT,
     `data_inserimento`   DATE,
     `totale_mensile`     BIGINT,
     `descrizione`        VARCHAR(255)
  );

CREATE TABLE `interessi_effettivi`
  (
     `id`                 INT PRIMARY KEY auto_increment,
     `identrataeffettiva` INT,
     `data_inserimento`   DATE,
     `totale_mensile`     BIGINT,
     `descrizione`        VARCHAR(255)
  );

CREATE TABLE `altre_entrate_effettive`
  (
     `id`                 INT PRIMARY KEY auto_increment,
     `identrataeffettiva` INT,
     `data_inserimento`   DATE,
     `totale_mensile`     BIGINT,
     `descrizione`        VARCHAR(255)
  );

CREATE TABLE `entrate_mensili_previste`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `identratemensile` INT,
     `data_inserimento` DATE
  );

CREATE TABLE `risparmi_previste`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `identrataprevista` INT,
     `data_inserimento`  DATE,
     `totale_mensile`    BIGINT
  );

CREATE TABLE `busta_paga_previste`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `identrataprevista` INT,
     `data_inserimento`  DATE,
     `totale_mensile`    BIGINT,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `bonus_previste`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `identrataprevista` INT,
     `data_inserimento`  DATE,
     `totale_mensile`    BIGINT,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `interessi_previste`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `identrataprevista` INT,
     `data_inserimento`  DATE,
     `totale_mensile`    BIGINT,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `altre_entrate_previste`
  (
     `id`                INT PRIMARY KEY auto_increment,
     `identrataprevista` INT,
     `data_inserimento`  DATE,
     `totale_mensile`    BIGINT,
     `descrizione`       VARCHAR(255)
  );

CREATE TABLE `uscite_mensili`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE
  );

CREATE TABLE `uscite_mensili_previste`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iduscitemensile`  INT,
     `data_inserimento` DATE
  );

CREATE TABLE `alimenti_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `regali_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_mediche_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_casa_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_trasporti_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_personali_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_animali_domestici_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_bollette_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_viaggi_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `spese_debiti_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `altre_spese_previste`
  (
     `id`                      INT PRIMARY KEY auto_increment,
     `iduscitemensilipreviste` INT,
     `data_inserimento`        DATE,
     `totale_mensile`          BIGINT,
     `descrizione`             VARCHAR(255)
  );

CREATE TABLE `uscite_mensili_effettive`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iduscitemensile`  INT,
     `data_inserimento` DATE
  );

CREATE TABLE `alimenti_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `regali_effettivi`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_mediche_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_casa_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_trasporti_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_personali_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_animali_domestici_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_bollette_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_viaggi_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `spese_debiti_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );

CREATE TABLE `altre_spese_effettive`
  (
     `id`                       INT PRIMARY KEY auto_increment,
     `iduscitemensilieffettive` INT,
     `data_inserimento`         DATE,
     `totale_mensile`           BIGINT,
     `descrizione`              VARCHAR(255)
  );