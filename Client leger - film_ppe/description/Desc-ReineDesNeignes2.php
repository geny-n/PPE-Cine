<?php
    if(isset($_GET['idfilm'])){
        $idfilm = $_GET['idfilm'];

        $unFilm = $unControleur -> selectWhereFilm($idfilm);

    }
?>

<!DOCTYPE>
<html>

<head>
    <title>Description</title>
</head>
<body>
    <div id="content">
        <div class="line-hor"></div>
        <div class="box">
            <div class="border-right">
                <div class="border-left">
                    <div class="inner">
                        <h3>Description <span><?php echo $unFilm['TITRE'];?></span></h3>
                        <p class="p1">
                    </div>
                </div>
            </div>
        </div>
        <div class="content">
            <ul class="movies">
                <h4><span>Synopsis</span></h4>
                <p align="left">
                    <?php echo $unFilm['synopsis'];?>
                </p>
                  
                <h4><span>Date de sortie</span></h4>
                <p><?php echo strftime("%d/%m/%Y", strtotime($unFilm['dateSortie']));?></p>
                                        
                <h4><span>Genre</span></h4>
                <p><?php echo $unFilm['CODEGENRE'];?></p>

                <h4><span>Réalisé par</span></h4>
                <p><?php echo $unFilm['NOMCOMPAGNIE'];?></p>
                                                            
                <h4><span>Durée</span></h4>
                <p><?php echo $unFilm['DUREE'];?> minutes</p>
                                                                    
                <h4><span>Avec</span></h4>
                <!--<p>Kristen Bell, Idina Menzel, Jonathan Groff, Josh Gad-->
                <p><?php echo $unFilm['avec'];?> </p>
                </p>
                                                                   
                <div class="wrapper">
                    <a href="index.php?page=0" class="link2">
                        <span>
                            <span>Retour</span>
                        </span>
                    </a>
                    <a href="index.php?page=8&idfilm=<?php echo $unFilm['idfilm']; ?>" class="link2">
                        <span>
                            <span>Réserver</span>
                        </span>
                    </a>
                </div>
            </ul>            
        </div>
    </div>
</body>
</html>