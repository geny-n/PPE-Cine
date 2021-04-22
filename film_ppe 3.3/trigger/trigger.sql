drop trigger if exists longcrypto;
DELIMITER |
CREATE TRIGGER longcrypto 
BEFORE INSERT ON paiement 
FOR EACH ROW
BEGIN

   if (new.code) > 999
        then signal sqlstate '45000'
        set message_text = 'Le numero de votre crypto doit comporter 3 chiffres';
    end if;

END |
DELIMITER ;

drop trigger if exists numcarte;
DELIMITER |
CREATE TRIGGER numcarte 
BEFORE INSERT ON paiement 
FOR EACH ROW
BEGIN

   if (new.carte) < 1000000000000000 or (new.carte) > 9999999999999999
        then signal sqlstate '45000'
        set message_text = 'Le numero de votre carte bancaire doit comporter 16 chiffres';
    end if;

END |
DELIMITER ;

drop trigger if exists validation_carteExpiration;
delimiter //
create trigger validation_carteExpiration
before insert
on paiement
for each row
if concat(new.annee,new.mois)<concat(year(now()),date_format(now(),'%m')) then
signal sqlstate '50000'
set message_text = 'Carte expirée';
end if//
delimiter ;

drop trigger if exists verifEmail;
DELIMITER |
CREATE TRIGGER verifEmail 
BEFORE INSERT ON reservation 
FOR EACH ROW
BEGIN

   if (new.email) <> (new.confirmation) 
        then signal sqlstate '45000'
        set message_text = 'Emails non identiques';
    end if;

END |
DELIMITER ;

drop trigger if exists verifMdp;
DELIMITER |
CREATE TRIGGER verifMdp 
BEFORE INSERT ON utilisateur 
FOR EACH ROW
BEGIN

   if (new.mdp) <> (new.confirmation) 
        then signal sqlstate '45000'
        set message_text = 'Mot de passe non identiques';
    end if;

END |
DELIMITER ;

drop trigger if exists verifPlace;
DELIMITER //
CREATE TRIGGER verifPlace 
BEFORE INSERT ON reservation 
FOR EACH ROW
BEGIN
   if (new.tarifPlein = 0) and (new.tarifReduit = 0) and (new.tarifEnfant = 0) and (new.tarifScolaire = 0)
        then signal sqlstate '45000'
        set message_text = 'Vous devez acheter au moins une place';
    end if;
END //
DELIMITER ;