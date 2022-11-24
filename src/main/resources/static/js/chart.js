var xValues = ['Italy', 'France', 'Spain', 'Brasil']
var yValues = [55, 49, 44, 24, 15]
var barColors = ['#F95B5A', '#1CB0A2', '#435360', '#FFA126', '#F4D034']
var ctx = document.getElementById('donut').getContext('2d')
console.log('hi', ctx)
var myChart = new Chart(ctx, {
  type: 'doughnut',
  data: {
    labels: xValues,
    datasets: [
      {
        backgroundColor: barColors,
        data: yValues,
      },
    ],
  },
  options: {
    legend: {
      labels: {
        fontColor: 'pink',
      },
    },
    elements: {
      arc: {
        borderWidth: 0,
      },
    },
    title: {
      display: true,
      text: 'World Wide Wine Production 2018',
      fontColor: 'orange',
      fontSize: '18',
    },
  },
})

var xValues = ['Italy', 'France', 'Spain', 'USA']
var yValues = [55, 49, 44, 24, 15]
var barColors = ['#F95B5A', '#1CB0A2', '#435360', '#FFA126', '#F4D034']
var ctx = document.getElementById('bar').getContext('2d')
console.log('hi', ctx)
var myChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: xValues,
    datasets: [
      {
        backgroundColor: barColors,
        data: yValues,
      },
    ],
  },
  options: {
    legend: {
      labels: {
        fontColor: 'white', //set your desired color
      },
    },
    title: {
      display: true,
      text: 'World Wide Wine Production 2018',
      fontColor: 'white',
      fontSize: '18',
      fontWeight: 'thin',
    },
  },
})

var xValues = ['Italy', 'France', 'Spain', 'USA']
var yValues = [55, 49, 44, 24, 15]
var barColors = ['#435360']

var ctx = document.getElementById('line').getContext('2d')
console.log('hi', ctx)
var myChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: xValues,
    datasets: [
      {
        backgroundColor: barColors,
        data: yValues,
      },
    ],
  },
  options: {
    title: {
      display: true,
      text: 'World Wide Wine Production 2018',
    },
  },
})
