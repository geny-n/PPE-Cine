<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
<div class="content">
	<h3><span>Prochainement</span></h3>
    <ul class="movies">
		<?php
            $lesFilms = $unControleur -> selectAllFilms(1);
            foreach ($lesFilms as $unFilm) { 
        ?>

        
            <li>
                <h4><?php echo $unFilm['TITRE']; ?></h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
                    src="<?php echo "images/".$unFilm['URL']; ?>" alt="" />
                <p><?php echo $unFilm['synopsis']; ?></p>  
            </li>   
        

		<?php
    		}
            $lesFilms = $unControleur -> selectAllFilms(1);
            foreach ($lesFilms as $unFilm) { 
        ?>

        
            <li>
                <div class="wrapper"><a href="index.php?page=4&idfilm=<?php echo $unFilm['idfilm']; ?>"
                        class="link2"><span><span>Description</span></span></a>
                </div>
            </li>    
       

        <?php
            }
        ?>

        <li class="clear">&nbsp;</li>
    </ul>
</div>
</body>

</html>