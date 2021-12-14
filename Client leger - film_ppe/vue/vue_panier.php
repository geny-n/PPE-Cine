
<center><h3>Vos réservations</h3></center><hr><br>

<section class="container">
    <div class="row">
    	<div class="col-12">
            <table class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th>Titre</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Date </th>	
						<th>Heure </th>					
                        <th>Tarif Scolaire </th>
                        <th>Tarif Enfant </th>
                        <th>Tarif Réduit </th>
                        <th>Tarif Plein </th>
                        <th>Prix total</th>
                    </tr>
                </thead>
                <tbody>
					<?php
						$total = 0;

						foreach ($panier as $unPanier){
							echo "
							<form method='post'>
								<tr>
									<td>".$unPanier['titre']."</td>
									<td>".$unPanier['nom']."</td>
									<td>".$unPanier['prenom']."</td>
									<td>".$unPanier['date_jour']."</td>
									<td>".$unPanier['date_heure']."</td>
									<td>".$unPanier['tarifScolaire']."</td>
									<td>".$unPanier['tarifEnfant']."</td>
									<td>".$unPanier['tarifReduit']."</td>
									<td>".$unPanier['tarifPlein']."</td>
									<td>".$unPanier['total']."</td>
								</tr>";
							$total += $unPanier['total'];
						}
					?>
				</tbody>
			</table>
			<p>
			<?php
				echo "<br/> Montant total facture : " .$total. " Euros";
			?>
			</p>
		</div>
	</div>
</section>
