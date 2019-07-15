doMath = function(x, y)
{
    function moreMath()
    {
        let answer = x + y;
        console.log(answer);
    }
    return moreMath();
}

//demo this
function dwightJob(title){
    let anything = 55;
    return function(prefix){
        console.log(anything);
        return prefix + ' ' + title;
    };
}

let title = dwightJob('Salesman');

alert(title('Top'));