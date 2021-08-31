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

CREATE TABLE `uscite_annuali`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `data_inserimento` DATE
  );

CREATE TABLE `altre_uscite`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iduscita`         INT,
     `data_spesa`       DATE,
     `data_inserimento` DATE,
     `descrizione`      VARCHAR(255)
  );

CREATE TABLE `animali_domestici`
  (
     `id`               INT PRIMARY KEY auto_increment,
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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
     `iduscita`         INT,
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

ALTER TABLE `salario`
  ADD FOREIGN KEY (`entrateid`) REFERENCES `entrate_annuali` (`id`);

ALTER TABLE `altre_entrate`
  ADD FOREIGN KEY (`entrateid`) REFERENCES `entrate_annuali` (`id`);

ALTER TABLE `altro_salario`
  ADD FOREIGN KEY (`idsalario`) REFERENCES `salario` (`id`);

ALTER TABLE `bonus`
  ADD FOREIGN KEY (`idsalario`) REFERENCES `salario` (`id`);

ALTER TABLE `busta_paga`
  ADD FOREIGN KEY (`idsalario`) REFERENCES `salario` (`id`);

ALTER TABLE `mance`
  ADD FOREIGN KEY (`idsalario`) REFERENCES `salario` (`id`);

ALTER TABLE `commissioni`
  ADD FOREIGN KEY (`idsalario`) REFERENCES `salario` (`id`);

ALTER TABLE `altre_entrate_ae`
  ADD FOREIGN KEY (`id_altre_entrate`) REFERENCES `altre_entrate` (`id`);

ALTER TABLE `dividendi`
  ADD FOREIGN KEY (`id_altre_entrate`) REFERENCES `altre_entrate` (`id`);

ALTER TABLE `interessi`
  ADD FOREIGN KEY (`id_altre_entrate`) REFERENCES `altre_entrate` (`id`);

ALTER TABLE `regali`
  ADD FOREIGN KEY (`id_altre_entrate`) REFERENCES `altre_entrate` (`id`);

ALTER TABLE `rimborsi`
  ADD FOREIGN KEY (`id_altre_entrate`) REFERENCES `altre_entrate` (`id`);

ALTER TABLE `trasferimenti_risparmi`
  ADD FOREIGN KEY (`id_altre_entrate`) REFERENCES `altre_entrate` (`id`);

ALTER TABLE `altre_uscite`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `animali_domestici`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `assicurazione`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `bollette`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `casa`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `debiti`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `divertimento`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `figli`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `istruzione`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `regali_uscite`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `spese_mediche`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `spese_quotidiane`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `tecnologia`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `trasporti`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `viaggi`
  ADD FOREIGN KEY (`iduscita`) REFERENCES `uscite_annuali` (`id`);

ALTER TABLE `alimenti_animali`
  ADD FOREIGN KEY (`idanimali`) REFERENCES `animali_domestici` (`id`);

ALTER TABLE `altro_animali_domestici`
  ADD FOREIGN KEY (`idanimali`) REFERENCES `animali_domestici` (`id`);

ALTER TABLE `forniture_animali`
  ADD FOREIGN KEY (`idanimali`) REFERENCES `animali_domestici` (`id`);

ALTER TABLE `giocattoli_animali`
  ADD FOREIGN KEY (`idanimali`) REFERENCES `animali_domestici` (`id`);

ALTER TABLE `veterinario_animali`
  ADD FOREIGN KEY (`idanimali`) REFERENCES `animali_domestici` (`id`);

ALTER TABLE `altre_assicurazioni`
  ADD FOREIGN KEY (`idassicurazione`) REFERENCES `assicurazione` (`id`);

ALTER TABLE `assicurazione_auto`
  ADD FOREIGN KEY (`idassicurazione`) REFERENCES `assicurazione` (`id`);

ALTER TABLE `assicurazione_casa`
  ADD FOREIGN KEY (`idassicurazione`) REFERENCES `assicurazione` (`id`);

ALTER TABLE `assicurazione_salute`
  ADD FOREIGN KEY (`idassicurazione`) REFERENCES `assicurazione` (`id`);

ALTER TABLE `assicurazione_vita`
  ADD FOREIGN KEY (`idassicurazione`) REFERENCES `assicurazione` (`id`);

ALTER TABLE `altre_bollette`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_acqua`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_elettricita`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_gas`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_internet`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_rifiuti`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_telefono`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `bollette_tv`
  ADD FOREIGN KEY (`idbollette`) REFERENCES `bollette` (`id`);

ALTER TABLE `affitto`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `altro_casa`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `arredamento`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `forniture_casa`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `giardinaggio`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `imposte_immobiliari`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `manutenzione_casa`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `miglioramenti_casa`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `trasloco`
  ADD FOREIGN KEY (`idcasa`) REFERENCES `casa` (`id`);

ALTER TABLE `altri_prestiti`
  ADD FOREIGN KEY (`iddebiti`) REFERENCES `debiti` (`id`);

ALTER TABLE `altro_debito`
  ADD FOREIGN KEY (`iddebiti`) REFERENCES `debiti` (`id`);

ALTER TABLE `carte_credito`
  ADD FOREIGN KEY (`iddebiti`) REFERENCES `debiti` (`id`);

ALTER TABLE `imposte_locali`
  ADD FOREIGN KEY (`iddebiti`) REFERENCES `debiti` (`id`);

ALTER TABLE `imposte_statali`
  ADD FOREIGN KEY (`iddebiti`) REFERENCES `debiti` (`id`);

ALTER TABLE `prestiti_studio`
  ADD FOREIGN KEY (`iddebiti`) REFERENCES `debiti` (`id`);

ALTER TABLE `altro_divertimento`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `attivita_outside`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `concerti_spettacoli`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `film`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `fotografia`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `hobby`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `libri_divertimento`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `musica`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `partite`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `sport`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `teatro`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `tv_divertimento`
  ADD FOREIGN KEY (`iddivertimento`) REFERENCES `divertimento` (`id`);

ALTER TABLE `altro_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `asilo`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `attivita_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `giocattoli_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `paghetta_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `scuola_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `spese_mediche_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `vestiti_figli`
  ADD FOREIGN KEY (`idfigli`) REFERENCES `figli` (`id`);

ALTER TABLE `altro_istruzione`
  ADD FOREIGN KEY (`idistruzione`) REFERENCES `istruzione` (`id`);

ALTER TABLE `lezioni_indipendenti`
  ADD FOREIGN KEY (`idistruzione`) REFERENCES `istruzione` (`id`);

ALTER TABLE `libri_istruzione`
  ADD FOREIGN KEY (`idistruzione`) REFERENCES `istruzione` (`id`);

ALTER TABLE `rette_istruzione`
  ADD FOREIGN KEY (`idistruzione`) REFERENCES `istruzione` (`id`);

ALTER TABLE `altro_regali`
  ADD FOREIGN KEY (`idregaliuscite`) REFERENCES `regali_uscite` (`id`);

ALTER TABLE `donazioni_benefiche`
  ADD FOREIGN KEY (`idregaliuscite`) REFERENCES `regali_uscite` (`id`);

ALTER TABLE `regali_t`
  ADD FOREIGN KEY (`idregaliuscite`) REFERENCES `regali_uscite` (`id`);

ALTER TABLE `altro_spese_mediche`
  ADD FOREIGN KEY (`idspesemediche`) REFERENCES `spese_mediche` (`id`);

ALTER TABLE `cure_specialistiche`
  ADD FOREIGN KEY (`idspesemediche`) REFERENCES `spese_mediche` (`id`);

ALTER TABLE `dottori`
  ADD FOREIGN KEY (`idspesemediche`) REFERENCES `spese_mediche` (`id`);

ALTER TABLE `emergenze`
  ADD FOREIGN KEY (`idspesemediche`) REFERENCES `spese_mediche` (`id`);

ALTER TABLE `farmaci`
  ADD FOREIGN KEY (`idspesemediche`) REFERENCES `spese_mediche` (`id`);

ALTER TABLE `abbonamenti`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `altro_spese_quotidiane`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `igiene_personale`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `lavanderia`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `parrucchiere`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `ristoranti`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `supermercati`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `vestiti_spese_quotidiane`
  ADD FOREIGN KEY (`idspesequotidiane`) REFERENCES `spese_quotidiane` (`id`);

ALTER TABLE `altro_tecnologia`
  ADD FOREIGN KEY (`idtecnologia`) REFERENCES `tecnologia` (`id`);

ALTER TABLE `hardware`
  ADD FOREIGN KEY (`idtecnologia`) REFERENCES `tecnologia` (`id`);

ALTER TABLE `servizi_hosting`
  ADD FOREIGN KEY (`idtecnologia`) REFERENCES `tecnologia` (`id`);

ALTER TABLE `serizi_online`
  ADD FOREIGN KEY (`idtecnologia`) REFERENCES `tecnologia` (`id`);

ALTER TABLE `software`
  ADD FOREIGN KEY (`idtecnologia`) REFERENCES `tecnologia` (`id`);

ALTER TABLE `altro_trasporti`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `bollo`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `carburante`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `forniture_trasporti`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `prestiti_auto`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `riparazioni_auto`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `trasporto_pubblico`
  ADD FOREIGN KEY (`idtrasporti`) REFERENCES `trasporti` (`id`);

ALTER TABLE `altro_viaggi`
  ADD FOREIGN KEY (`idviaggio`) REFERENCES `trasporti` (`id`);

ALTER TABLE `alimenti_viaggi`
  ADD FOREIGN KEY (`idviaggio`) REFERENCES `trasporti` (`id`);

ALTER TABLE `biglietti_aerei_viaggi`
  ADD FOREIGN KEY (`idviaggio`) REFERENCES `trasporti` (`id`);

ALTER TABLE `divertimento_viaggi`
  ADD FOREIGN KEY (`idviaggio`) REFERENCES `trasporti` (`id`);

ALTER TABLE `hotel_viaggi`
  ADD FOREIGN KEY (`idviaggio`) REFERENCES `trasporti` (`id`);

ALTER TABLE `trasporto_viaggi`
  ADD FOREIGN KEY (`idviaggio`) REFERENCES `trasporti` (`id`);

ALTER TABLE `entrate_mensili_effettive`
  ADD FOREIGN KEY (`identratemensile`) REFERENCES `entrate_mensili` (`id`);

ALTER TABLE `entrate_mensili_previste`
  ADD FOREIGN KEY (`identratemensile`) REFERENCES `entrate_mensili` (`id`);

ALTER TABLE `risparmi_effettivi`
  ADD FOREIGN KEY (`identrataeffettiva`) REFERENCES `entrate_mensili_effettive`
  (`id`);

ALTER TABLE `busta_paga_effettivi`
  ADD FOREIGN KEY (`identrataeffettiva`) REFERENCES `entrate_mensili_effettive`
  (`id`);

ALTER TABLE `bonus_effettivi`
  ADD FOREIGN KEY (`identrataeffettiva`) REFERENCES `entrate_mensili_effettive`
  (`id`);

ALTER TABLE `interessi_effettivi`
  ADD FOREIGN KEY (`identrataeffettiva`) REFERENCES `entrate_mensili_effettive`
  (`id`);

ALTER TABLE `altre_entrate_effettive`
  ADD FOREIGN KEY (`identrataeffettiva`) REFERENCES `entrate_mensili_effettive`
  (`id`);

ALTER TABLE `risparmi_previste`
  ADD FOREIGN KEY (`identrataprevista`) REFERENCES `entrate_mensili_previste` (
  `id`);

ALTER TABLE `busta_paga_previste`
  ADD FOREIGN KEY (`identrataprevista`) REFERENCES `entrate_mensili_previste` (
  `id`);

ALTER TABLE `bonus_previste`
  ADD FOREIGN KEY (`identrataprevista`) REFERENCES `entrate_mensili_previste` (
  `id`);

ALTER TABLE `interessi_previste`
  ADD FOREIGN KEY (`identrataprevista`) REFERENCES `entrate_mensili_previste` (
  `id`);

ALTER TABLE `altre_entrate_previste`
  ADD FOREIGN KEY (`identrataprevista`) REFERENCES `entrate_mensili_previste` (
  `id`);

ALTER TABLE `uscite_mensili_previste`
  ADD FOREIGN KEY (`iduscitemensile`) REFERENCES `uscite_mensili` (`id`);

ALTER TABLE `uscite_mensili_effettive`
  ADD FOREIGN KEY (`iduscitemensile`) REFERENCES `uscite_mensili` (`id`);

ALTER TABLE `alimenti_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `regali_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_mediche_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_casa_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_trasporti_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_personali_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_animali_domestici_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_bollette_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_viaggi_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `spese_debiti_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `altre_spese_previste`
  ADD FOREIGN KEY (`iduscitemensilipreviste`) REFERENCES
  `uscite_mensili_previste` (`id`);

ALTER TABLE `alimenti_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `regali_effettivi`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_mediche_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_casa_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_trasporti_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_personali_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_animali_domestici_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_bollette_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_debiti_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `spese_viaggi_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`);

ALTER TABLE `altre_spese_effettive`
  ADD FOREIGN KEY (`iduscitemensilieffettive`) REFERENCES
  `uscite_mensili_effettive` (`id`); 