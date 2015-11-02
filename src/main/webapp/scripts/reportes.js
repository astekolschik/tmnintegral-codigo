function validarFormReporte(){
	if ($('#tipo-reporte').val() == -1){
		alert('Debe seleccionar el tipo de reporte.');
		return false;
	}
	
	if ($('#fecha-desde').val() == -1){
		alert('Debe seleccionar el tipo de reporte.');
		return false;
	}
	
	return true;
}

function generarGrafico(data) {
	        var margin = {
	            top: 20,
	            right: 80,
	            bottom: 30,
	            left: 50
	        },
	        width = 800 - margin.left - margin.right,
	            height = 700 - margin.top - margin.bottom;

	        var parseDate = d3.time.format("%Y-%m-%d %H:%M:%S.%L").parse;

	        var x = d3.time.scale()
	            .range([0, 600]);

	        var y = d3.scale.linear()
	            .range([500, 0]);

	        var color = d3.scale.category10();

	        var xAxis = d3.svg.axis()
	            .scale(x)
	            .orient("bottom");

	        var yAxis = d3.svg.axis()
	            .scale(y)
	            .orient("left");

	        var line = d3.svg.line()
	            .interpolate("basis")
	            .x(function (d) {
	            return x(d.Date);
	        })
	            .y(function (d) {
	            return y(d.Value);
	        });

	        var svg = d3.select("#div-reporte").append("svg")
	            .attr("width", width + margin.left + margin.right)
	            .attr("height", height + margin.top + margin.bottom)
	            .append("g")
	            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

	        color.domain(data.map(function (d) { return d.Equipment; }));

	        data.forEach(function (kv) {
	            kv.Data.forEach(function (d) {
	                d.Date = parseDate(d.Date);
	            });
	        });

	        var equipments = data;

	        var minX = d3.min(data, function (kv) { return d3.min(kv.Data, function (d) { return d.Date; }) });
	        var maxX = d3.max(data, function (kv) { return d3.max(kv.Data, function (d) { return d.Date; }) });
	        var minY = d3.min(data, function (kv) { return d3.min(kv.Data, function (d) { return d.Value; }) });
	        var maxY = d3.max(data, function (kv) { return d3.max(kv.Data, function (d) { return d.Value; }) });

	        x.domain([minX, maxX]);
	        y.domain([minY, maxY]);

	        svg.append("g")
	            .attr("class", "x axis")
	            .attr("transform", "translate(0," + 500 + ")")
	            .call(xAxis);

	        svg.append("g")
	            .attr("class", "y axis")
	            .call(yAxis)
	            .append("text")
	            .attr("transform", "rotate(-90)")
	            .attr("y", 6)
	            .attr("dy", ".71em")
	            .style("text-anchor", "end")
	            .text("Consumo");

	        var city = svg.selectAll(".equipment")
	            .data(equipments)
	            .enter().append("g")
	            .attr("class", "equipment");

	        city.append("path")
	            .attr("class", "line")
	            .attr("d", function (d) {
	            return line(d.Data);
	        })
	            .style("stroke", function (d) {
	            return color(d.Equipment);
	        });

	        city.append("text")
	            .datum(function (d) {
	            return {
	                name: d.Equipment,
	                date: d.Data[d.Data.length - 1].Date,
	                value: d.Data[d.Data.length - 1].Value
	            };
	        })
	            .attr("transform", function (d) {
	            return "translate(" + x(d.date) + "," + y(d.value) + ")";
	        })
	            .attr("x", 3)
	            .attr("dy", ".35em")
	            .text(function (d) {
	                return d.name;
	        });
}