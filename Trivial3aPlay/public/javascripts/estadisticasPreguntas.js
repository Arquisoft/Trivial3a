var jugadas;
var ganadas;
	$(function () {

		    $(document).ready(function () {
		
		        // Build the chart
		        $('#preguntas').highcharts({
		            chart: {
		                plotBackgroundColor: null,
		                plotBorderWidth: null,
		                plotShadow: false
		            },
		            title: {
		                text: 'Estadisticas preguntas'
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
		                    ['Preguntas jugadas',   jugadas],
		                    ['Preguntas ganadas',  ganadas],
		               ]
		            }]
		        });
		    });

		});