var jugadas;
var ganadas;
		$("td").click(function () {

		    $(document).ready(function () {
		        // Build the chart

		        $('#partidas').highcharts({
		            chart: {
		                plotBackgroundColor: null,
		                plotBorderWidth: null,
		                plotShadow: false
		            },
		            title: {
		                text: 'Estadisticas partidas'
		            },
		            tooltip: {
		                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		            },
		            plotOptions: {
		                pie: {
		                    allowPointSelect: true,
		                    cursor: 'pointer',
		                    dataLabels: {
		                        enabled: false
		                    },
		                    showInLegend: true
		                }
		            },
		            series: [{
		                type: 'pie',
		                name: 'Browser share',
		                data: [
		                	['Partidas ganadas',  ganadas],
		                    ['Partidas perdidas',   jugadas],
		               ]
		            }]
		        });
		    });

		});