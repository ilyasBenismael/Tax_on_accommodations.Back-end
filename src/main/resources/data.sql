
INSERT INTO `secteur` (`id`, `code`, `libelle`) VALUES ('1', 'CS1', 'S1');
INSERT INTO `secteur` (`id`, `code`, `libelle`) VALUES ('2', 'CS2', 'S2');
INSERT INTO `secteur` (`id`, `code`, `libelle`) VALUES ('3', 'CS3', 'S3');


INSERT INTO `quartier` (`id`, `code`, `libelle`, `nom`, `secteur`) VALUES ('1', 'CQ1', 'q1', 'quartier1', '1');
INSERT INTO `quartier` (`id`, `code`, `libelle`, `nom`, `secteur`) VALUES ('2', 'CQ2', 'q2', 'quartier2', '1');
INSERT INTO `quartier` (`id`, `code`, `libelle`, `nom`, `secteur`) VALUES ('3', 'CQ3', 'q3', 'quartier3', '2');
INSERT INTO `quartier` (`id`, `code`, `libelle`, `nom`, `secteur`) VALUES ('4', 'CQ4', 'q4', 'quartier4', '2');
INSERT INTO `quartier` (`id`, `code`, `libelle`, `nom`, `secteur`) VALUES ('5', 'CQ5', 'q5', 'quartier5', '3');
INSERT INTO `quartier` (`id`, `code`, `libelle`, `nom`, `secteur`) VALUES ('6', 'CQ6', 'q6', 'quartier6', '3');


INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('1', 'CR1', 'r1', 'rue1', '1');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('2', 'CR2', 'r2', 'rue2', '1');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('3', 'CR3', 'r3', 'rue3', '2');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('4', 'CR4', 'r4', 'rue4', '2');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('5', 'CR5', 'r5', 'rue5', '3');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('6', 'CR6', 'r6', 'rue6', '3');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('7', 'CR7', 'r7', 'rue7', '4');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('8', 'CR8', 'r8', 'rue8', '4');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('9', 'CR9', 'r9', 'rue9', '5');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('10', 'CR10', 'r10', 'rue10', '5');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('11', 'CR11', 'r11', 'rue11', '6');
INSERT INTO `rue` (`id`, `code`, `libelle`, `nom`, `quartier`) VALUES ('12', 'CR12', 'r12', 'rue12', '6');


INSERT INTO `categorie_local` (`id`, `code`, `libelle`, `name`) VALUES ('1', 'CL1', 'dd', 'duplex');
INSERT INTO `categorie_local` (`id`, `code`, `libelle`, `name`) VALUES ('2', 'CL2', 'vv', 'villa');
INSERT INTO `categorie_local` (`id`, `code`, `libelle`, `name`) VALUES ('3', 'CL3', 'mm', 'maison');
INSERT INTO `categorie_local` (`id`, `code`, `libelle`, `name`) VALUES ('4', 'CL4', 'aa', 'appartement');


INSERT INTO `redevable` (`id`, `cin`, `nom`, `prenom`) VALUES ('1','R111','BENISMAIL','Ilyas');
INSERT INTO `redevable` (`id`, `cin`, `nom`, `prenom`) VALUES ('2','R112','BENMARZOUQ','Mehdi');
INSERT INTO `redevable` (`id`, `cin`, `nom`, `prenom`) VALUES ('3','R113','BENKRIMI','Zineb');
INSERT INTO `redevable` (`id`, `cin`, `nom`, `prenom`) VALUES ('4','R114','BENZAOUAGH','Imane');
INSERT INTO `redevable` (`id`, `cin`, `nom`, `prenom`) VALUES ('5','R115','ALAHYAD','Meryem');
INSERT INTO `redevable` (`id`, `cin`, `nom`, `prenom`) VALUES ('6','R116','AITYOUSSEF','Nassima');

INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('1', '2020', '1', 'ref1', '1', '1', '1');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('2', '2020', '2', 'ref2', '1', '1', '1');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('3', '2020', '1', 'ref3', '2', '1', '2');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('4', '2020', '3', 'ref4', '2', '1', '2');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('5', '2020', '2', 'ref5', '3', '1', '3');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('6', '2020', '4', 'ref6', '3', '1', '3');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('7', '2020', '4', 'ref7', '4', '1', '4');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('8', '2021', '1', 'ref8', '4', '1', '4');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('9', '2021', '2', 'ref9', '1', '2', '5');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('10', '2021', '2', 'ref10', '1', '2', '5');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('11', '2019', '3', 'ref11', '2', '2', '6');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('12', '2020', '4', 'ref12', '2', '2', '6');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('13', '2021', '3', 'ref13', '3', '2', '7');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('14', '2020', '3', 'ref14', '3', '2', '7');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('15', '2022', '2', 'ref15', '4', '2', '8');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('16', '2019', '1', 'ref16', '4', '2', '8');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('17', '2020', '2', 'ref17', '1', '3', '9');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('18', '2021', '2', 'ref18', '1', '3', '9');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('19', '2022', '3', 'ref19', '2', '3', '10');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('20', '2019', '1', 'ref20', '2', '3', '10');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('21', '2022', '4', 'ref21', '3', '3', '11');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('22', '2021', '3', 'ref22', '3', '3', '11');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('23', '2020', '3', 'ref23', '4', '3', '12');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('24', '2020', '2', 'ref24', '4', '3', '12');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('25', '2021', '1', 'ref25', '1', '4', '1');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('26', '2022', '2', 'ref26', '1', '4', '1');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('27', '2020', '2', 'ref27', '2', '4', '2');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('28', '2022', '3', 'ref28', '2', '4', '2');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('29', '2021', '1', 'ref29', '3', '4', '3');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('30', '2019', '2', 'ref30', '3', '4', '3');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('31', '2020', '4', 'ref31', '4', '4', '4');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('32', '2021', '3', 'ref32', '4', '4', '4');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('33', '2020', '1', 'ref33', '1', '5', '5');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('34', '2021', '4', 'ref34', '1', '5', '5');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('35', '2022', '4', 'ref35', '2', '5', '6');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('36', '2020', '3', 'ref36', '2', '5', '6');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('37', '2021', '2', 'ref37', '3', '5', '7');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('38', '2021', '1', 'ref38', '3', '5', '7');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('39', '2020', '1', 'ref39', '4', '5', '8');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('40', '2022', '4', 'ref40', '4', '5', '8');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('41', '2020', '1', 'ref41', '1', '6', '9');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('42', '2021', '2', 'ref42', '1', '6', '9');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('43', '2022', '2', 'ref43', '2', '6', '10');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('44', '2022', '3', 'ref44', '2', '6', '10');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('45', '2021', '1', 'ref45', '3', '6', '11');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('46', '2022', '4', 'ref46', '3', '6', '11');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('47', '2020', '4', 'ref47', '4', '6', '12');
INSERT INTO `local` (`id`, `dernier_annee_payee`, `dernier_trimestre_payee`, `ref`, `categorie_local`, `redevable`, `rue`) VALUES ('48', '2019', '3', 'ref48', '4', '6', '12');


INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('1', '2015-01-01 14:18:58', '2010-01-01 14:18:58', '0.006', '600', '0.06', 'R1', '1');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('2', '2020-01-01 14:18:58', '2015-01-02 14:18:58', '0.007', '700', '0.07', 'R2', '1');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('3', '2025-01-01 14:18:58', '2020-01-02 14:18:58', '0.008', '800', '0.08', 'R3', '1');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('4', '2015-01-01 14:18:58', '2010-01-01 14:18:58', '0.009', '900', '0.09', 'R4', '2');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('5', '2020-01-01 14:18:58', '2015-01-02 14:18:58', '0.010', '1000', '0.10', 'R5', '2');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('6', '2025-01-01 14:18:58', '2020-01-02 14:18:58', '0.012', '1200', '0.12', 'R6', '2');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('7', '2015-01-01 14:18:58', '2010-01-01 14:18:58', '0.007', '700', '0.07', 'R7', '3');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('8', '2020-01-01 14:18:58', '2015-01-02 14:18:58', '0.008', '800', '0.08', 'R8', '3');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('9', '2025-01-01 14:18:58', '2020-01-02 14:18:58', '0.009', '900', '0.09', 'R9', '3');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('10', '2015-01-01 14:18:58', '2010-01-01 14:18:58', '0.004', '400', '0.04', 'R10', '4');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('11', '2020-01-01 14:18:58', '2015-01-02 14:18:58', '0.005', '500', '0.05', 'R11', '4');
INSERT INTO `taux_trim` (`id`, `date_app_max`, `date_app_min`, `montant_majoration`, `montant_nuit`, `montant_retard`, `ref`, `categorie_local`) VALUES ('12', '2025-01-01 14:18:58', '2020-01-02 14:18:58', '0.006', '600', '0.06', 'R12', '4');


INSERT INTO `taux_annuelle` (`id`, `date_max`, `date_min`, `montant_de_base`, `ref`) VALUES ('1', '2015-01-01 14:38:57', '2010-01-01 14:38:57', '0', 'R1');
INSERT INTO `taux_annuelle` (`id`, `date_max`, `date_min`, `montant_de_base`, `ref`) VALUES ('2', '2020-01-01 14:38:57', '2015-01-02 14:38:57', '0', 'R2');
INSERT INTO `taux_annuelle` (`id`, `date_max`, `date_min`, `montant_de_base`, `ref`) VALUES ('3', '2025-01-01 14:38:57', '2020-01-02 14:38:57', '0', 'R3');










