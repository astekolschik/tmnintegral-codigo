function generarGrafico(data) {
	/*var data = [
	            {
	                "City": "New York",
	                "Data": [
	                    {
	                        "Date": "20111001",
	                        "Value": "63.4"
	                    },
	                    {
	                        "Date": "20111002",
	                        "Value": "58.0"
	                    },
	                    {
	                        "Date": "20111003",
	                        "Value": "53.3"
	                    }
	                ]
	            },
	            {
	                "City": "San Francisco",
	                "Data": [
	                    {
	                        "Date": "20111001",
	                        "Value": "62.7"
	                    },
	                    {
	                        "Date": "20111002",
	                        "Value": "59.9"
	                    },
	                    {
	                        "Date": "20111003",
	                        "Value": "59.1"
	                    }
	                ]
	            },
	            {
	                "City": "Austin",
	                "Data": [
	                    {
	                        "Date": "20111001",
	                        "Value": "72.2"
	                    },
	                    {
	                        "Date": "20111002",
	                        "Value": "67.7"
	                    },
	                    {
	                        "Date": "20111003",
	                        "Value": "69.4"
	                    }
	                ]
	            }
	        ];
*/
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

/*
function generarGrafico() {
var data = [{
    "sale": "202",
    "year": "2000"
}, {
    "sale": "215",
    "year": "2002"
}, {
    "sale": "179",
    "year": "2004"
}, {
    "sale": "199",
    "year": "2006"
}, {
    "sale": "134",
    "year": "2008"
}, {
    "sale": "176",
    "year": "2010"
}];


var data2 = [{
    "sale": "152",
    "year": "2000"
}, {
    "sale": "189",
    "year": "2002"
}, {
    "sale": "179",
    "year": "2004"
}, {
    "sale": "199",
    "year": "2006"
}, {
    "sale": "134",
    "year": "2008"
}, {
    "sale": "176",
    "year": "2010"
}];



var vis = d3.select("#div-reporte"),
    WIDTH = 1000,
    HEIGHT = 500,
    MARGINS = {
        top: 20,
        right: 20,
        bottom: 20,
        left: 50
    },

    xScale = d3.scale.linear().range([MARGINS.left, WIDTH - MARGINS.right]).domain([2000, 2010]),

    yScale = d3.scale.linear().range([HEIGHT - MARGINS.top, MARGINS.bottom]).domain([134, 215]),

    xAxis = d3.svg.axis()
    .scale(xScale),

    yAxis = d3.svg.axis()
    .scale(yScale)
    .orient("left");





vis.append("svg:g")
    .attr("class", "x axis")
    .attr("transform", "translate(0," + (HEIGHT - MARGINS.bottom) + ")")
    .call(xAxis);

vis.append("svg:g")
    .attr("class", "y axis")
    .attr("transform", "translate(" + (MARGINS.left) + ",0)")
    .call(yAxis);

var lineGen = d3.svg.line()
    .x(function(d) {
        return xScale(d.year);
    })
    .y(function(d) {
        return yScale(d.sale);
    })
    .interpolate("basis");

vis.append('svg:path')
    .attr('d', lineGen(data))
    .attr('stroke', 'green')
    .attr('stroke-width', 2)
    .attr('fill', 'none');

vis.append('svg:path')
    .attr('d', lineGen(data2))
    .attr('stroke', 'blue')
    .attr('stroke-width', 2)
    .attr('fill', 'none');




}*/